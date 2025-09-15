package gameslib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GamesLibrary{

  private Set<Platform> platforms;

  private Set<Game> games;

  /**
   * Default constructor.
   */
  public GamesLibrary(){
    this.platforms = new TreeSet<Platform>();
    this.games = new TreeSet<Game>();
  }

  /**
   * Adds a new platform to the game library.
   *
   * @param platform Platform (must not be null)
   * @throws GamesLibraryException if platform is already in games library.
   */
  public void addPlatform(Platform platform){
    if (platform == null)
      throw new IllegalArgumentException("platform must not be null");

    if (platforms.contains(platform))
      throw new GamesLibraryException("Platform already in games library");

    platforms.add(platform);

  }

  /**
   * Removes the given platform and all games on this platform from the library.
   *
   * @param platform Platform to remove (along with all games), must be in
   * library and must not be null
   * @throws GamesLibraryException if platform is not in games library
   */
  public void removePlatform(Platform platform){

    if (platform == null)
      throw new IllegalArgumentException("platform must not be null");

    if (!platforms.contains(platform))
      throw new GamesLibraryException("platform is not in games library");

    games.removeIf(
        game -> game.getPlatform().equals(platform));
    platforms.remove(platform);

  }

  /**
   * Adds a new game to the games library.
   *
   * @param game game to add (must not be null)
   *
   * @throws GamesLibraryException if game is already in library or platform of
   * game is not in game library
   */
  public void addGame(Game game){

    if (game == null)
      throw new IllegalArgumentException("game must not be null");

    if (!platforms.contains(game.getPlatform()))
      throw new GamesLibraryException("Platform of game not in games library, add platform first");

    if (games.contains(game))
      throw new GamesLibraryException("Game already in games library");

    games.add(game);
  }

  /**
   * Removes a game from the game library.
   *
   * @param game game to remove, must not be null
   * @throws GamesLibraryException if game is not in library
   */
  public void removeGame(Game game){
    if (game == null)
      throw new IllegalArgumentException("game must not be null");

    if (!games.contains(game))
      throw new GamesLibraryException("game is not in games library");

    games.remove(game);
  }

  /**
   * Returns the sorted set of games.
   * The set must be ordered according to Game.compareTo
   * @return set of games as a read-only set
   */
  public Set<Game> getGamesReadOnly(){
    return Collections.unmodifiableSet(games);
  }

  /**
   * Returns the sorted set of platforms.
   * The set must be ordered according to Platform.compareTo
   * @return set of platforms as a read-only set
   */
  public Set<Platform> getPlatformsReadOnly(){
    return Collections.unmodifiableSet(platforms);
  }

  /**
   * Returns the game with the highest metacritic score.
   *
   * @return game with highest metacritic score (or null if games library is
   * empty)
   */
  // Streamline: easy
  public Game getBestGame(){
    return games
      .stream()
      .max((g1,g2) -> 
          Integer.compare(g1.getMetacriticScore(), g2.getMetacriticScore()))
      .orElse(null);
  }

  /**
   * Returns a map the maps a genre to the number of games of the genre in the
   * games library.
   *
   * @return map from genre to number of games of the genre
   */
  // Streamline: mittel bis schwer
  public Map<Genre, Long> getGenreCount(){

    return games
      .stream()
      .collect(
          Collectors.groupingBy(
            Game::getGenre,
            Collectors.counting()));
  }

  /**
   * Returns a map from the platforms to the set of games on that platform.
   */
  // Streamline: mittel bis schwer
  public Map<Platform, List<Game>> getGamesForPlatform(){
    return games
      .stream()
      .collect(Collectors.groupingBy(Game::getPlatform));
  }

  /**
   * Returns a map from all platforms to their average metacritic scores.
   */
  // Streamline: schwer
  public Map<Platform, Double> getAverageScoreForPlatform(){

    Map<Platform, List<Game>> gamesForPlatform = getGamesForPlatform();

    return gamesForPlatform
      .entrySet()
      .stream()
      .collect(
          Collectors.toMap(
            Map.Entry::getKey,
            entry -> entry
              .getValue()
              .stream()
              .mapToInt(Game::getMetacriticScore)
              .average()
              .orElse(0.0)));
  }

  /** 
   * Returns the platform with the highest averaga metacritic score.
   */
  // Streamline: mittel
  public Platform getBestPlatform(){

    Map<Platform, Double> averageScores = getAverageScoreForPlatform();

    return averageScores
      .entrySet()
      .stream()
      .max(
          (e1,e2) -> Double.compare(e1.getValue(),e2.getValue()))
      .map(Map.Entry::getKey)
      .orElse(null);
  }


  /**
   * Returns a list with all games ordered from highest to lowest metacritic
   * score.
   */
  // Streamline: einfach
  public List<Game> sortGamesByMetacriticScore(){
    return games
      .stream()
      .sorted(
          (g1,g2) -> -Integer.compare(g1.getMetacriticScore(),g2.getMetacriticScore()))
      .collect(Collectors.toList());
  }

  /**
   * Returns a list with all games ordered, first, by release year (ascending)
   * and, second, by name.
   */
  // Streamline: einfach
  public List<Game> sortGamesByReleaseYear(){
    return games
      .stream()
      .sorted(
          (game1,game2) -> {
            int result = game1.getReleaseYear() - game2.getReleaseYear();

            if (result == 0)
              result = game1.getName().compareTo(game2.getName());

            return result;
          })
      .collect(Collectors.toList());
  }

  /* ADDITIONAL METHODS */
  /**
   * Returns the average Metacritic score of all games.
   */
  public double getAverageMetacriticScore(){
    return games
      .stream()
      .mapToInt(Game::getMetacriticScore)
      .average()
      .orElse(0);
  }

  /**
   * Returns all games belonging to the given genre as a list.
   */
  public List<Game> getGamesForGenre(Genre genre){
    if (genre == null)
      throw new IllegalArgumentException("genre must not be null");

    return games
      .stream()
      .filter(game -> game.getGenre() == genre)
      .collect(Collectors.toList());
  }

  /** 
   * Returns true if there is a game released in the given time period, false
   * otherwise.
   *
   * @param begin begin of time period (inclusive)
   * @param end end of time period (inclusive)
   */
  public boolean gameReleasedBetween(int begin, int end){

    if (end < begin)
      throw new IllegalArgumentException("begin must be earlier or equal to end");

    return games
      .stream()
      .anyMatch(game ->
          game.getReleaseYear() >= begin && game.getReleaseYear() <= end);
  }

  /**
   * Returns all genres for which there is at least one game in the library as a
   * list.
   * The list does not contain duplicates
   */
  public List<Genre> getGenresWithGames(){
    return games
      .stream()
      .map(Game::getGenre)
      .distinct()
      .collect(Collectors.toList());
  }

  private Comparator<Game> metacriticComparator(){
    return (game1, game2) -> -Integer.compare(game1.getMetacriticScore(),game2.getMetacriticScore());
  }

  /**
   * Returns the top n ranking games according to the Metacritic score and
   * sorted from best to worst.
   * If there are less than n games, all games are return in sorted order from
   * best to worst.
   *
   * @param n the number of games
   */
  public List<Game> topGames(long n){
    return games
      .stream()
      .sorted(metacriticComparator())
      .limit(n)
      .collect(Collectors.toList());
  }

  /**
   * Creates a single String containing the names of the top 10 games (from best to worst) of the form:
   * <best game>, <second best game>, ..., <10th best game>
   *
   * The resulting string is shorter if there are less than 10 games
   */
  public String getTopTenListString(){
    return games
      .stream()
      .sorted(metacriticComparator())
      .limit(10)
      .map(game -> new StringBuilder(game.getName()))
      .reduce((builder,line) -> builder.append(", " + line))
      .orElseGet(StringBuilder::new)
      .toString();
  }

}

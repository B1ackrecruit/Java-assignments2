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
  public Game getBestGame(){
    return null;
  }

  /**
   * Returns a list with all games ordered from highest to lowest metacritic
   * score.
   */
  public List<Game> sortGamesByMetacriticScore(){
    return null;
  }

  /**
   * Returns a list with all games ordered, first, by release year (ascending)
   * and, second, by name.
   */
  public List<Game> sortGamesByReleaseYear(){
    return null;
  }

  /**
   * Returns the average Metacritic score of all games.
   */
  public double getAverageMetacriticScore(){
    return 0;
  }

  /**
   * Returns all games belonging to the given genre as a list.
   */
  public List<Game> getGamesForGenre(Genre genre){
    return null;
  }

  /** 
   * Returns true if there is a game released in the given time period, false
   * otherwise.
   *
   * @param begin begin of time period (inclusive)
   * @param end end of time period (inclusive)
   */
  public boolean gameReleasedBetween(int begin, int end){
    return false;
  }

  /**
   * Returns a map from the platforms to the set of games on that platform.
   */
  public Map<Platform, List<Game>> getGamesForPlatform(){
    return null;
  }

  /** 
   * Returns the platform with the highest averaga metacritic score.
   */
  public Platform getBestPlatform(){
    return null;
  }


  /**
   * Returns all genres for which there is at least one game in the library as a
   * list.
   * The list does not contain duplicates
   * Schwierigkeitsgrad: mittel
   */
  public List<Genre> getGenresWithGames(){
    return null;
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
    return null;
  }

  /**
   * Creates a single String containing the names of the top 10 games (from best to worst) of the form:
   * <best game>, <second best game>, ..., <10th best game>
   *
   * The resulting string is shorter if there are less than 10 games
   */
  public String getTopTenListString(){
    return null;
  }


  /**
   * Returns a map the maps a genre to the number of games of the genre in the
   * games library.
   *
   * @return map from genre to number of games of the genre
   */
  public Map<Genre, Long> getGenreCount(){
    return null;
  }


  /**
   * Returns a map from all platforms to their average metacritic scores.
   */
  public Map<Platform, Double> getAverageScoreForPlatform(){
    return null;
  }

}

package gameslib;

public class Game implements Comparable<Game> {

  private final String name;
  private final Genre genre;
  private final Platform platform;
  private final int releaseYear;
  private final int metacriticScore;

  public Game(String name, Genre genre, Platform platform, int releaseYear, int metacriticScore){

    if (name == null || name.isEmpty())
      throw new IllegalArgumentException("name must not be null or empty");

    if (genre == null)
      throw new IllegalArgumentException("genre must not be null");

    if (platform == null)
      throw new IllegalArgumentException("platform must not be null");

    if (releaseYear < 1970)
      throw new IllegalArgumentException("release year must be at least 1970");

    if (metacriticScore < 0 || metacriticScore > 100)
      throw new IllegalArgumentException("metacriticScore must be a value from 0.0 to 100.0");

    this.name = name;
    this.genre = genre;
    this.platform = platform;
    this.releaseYear = releaseYear;
    this.metacriticScore = metacriticScore;
  }

  public String getName() {
    return name;
  }

  public Genre getGenre() {
    return genre;
  }

  public Platform getPlatform() {
    return platform;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public int getMetacriticScore() {
    return metacriticScore;
  }

  @Override
  public int compareTo(Game other){
    if (other == null)
      throw new IllegalArgumentException("Other game must not be null");

    int result = name.compareTo(other.name);

    if (result == 0)
      result = genre.compareTo(other.genre);

    if (result == 0)
      result = platform.compareTo(other.platform);

    if (result == 0)
      result = this.releaseYear - other.releaseYear;

    if (result == 0)
      result = Integer.compare(metacriticScore, other.metacriticScore);

    return result;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((genre == null) ? 0 : genre.hashCode());
    result = prime * result + metacriticScore;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((platform == null) ? 0 : platform.hashCode());
    result = prime * result + releaseYear;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Game other = (Game) obj;
    if (genre != other.genre)
      return false;
    if (metacriticScore != other.metacriticScore)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (platform == null) {
      if (other.platform != null)
        return false;
    } else if (!platform.equals(other.platform))
      return false;
    if (releaseYear != other.releaseYear)
      return false;
    return true;
  }



}

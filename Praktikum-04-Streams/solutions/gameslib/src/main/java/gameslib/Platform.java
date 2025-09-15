package gameslib;

public class Platform implements Comparable<Platform>{

  private final String name;
  private final String company;

  public Platform(String name, String company){
    if (name == null || name.isEmpty())
      throw new IllegalArgumentException("name must not be null or empty");

    if (company == null || company.isEmpty())
      throw new IllegalArgumentException("company must not be null or empty");

    this.name = name;
    this.company = company;
  }

  public String getName() {
    return name;
  }


  public String getCompany() {
    return company;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((company == null) ? 0 : company.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (obj == null) return false;

    if (getClass() != obj.getClass()) return false;

    Platform other = (Platform) obj;

    if (company == null) {
      if (other.company != null)
        return false;
    } else if (!company.equals(other.company))
      return false;

    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString(){
    return String.format("{Platform: name = %s, company = %s}", name, company);
  }

  @Override
  public int compareTo(Platform other) {
    if (other == null)
      throw new IllegalArgumentException("other platform must not be null");

    int result = name.compareTo(other.name);

    if (result == 0)
      result = company.compareTo(other.company);

    return result;
  }

}

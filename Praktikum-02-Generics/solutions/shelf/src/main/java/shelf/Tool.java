package shelf;

public class Tool extends ShelfItem {

  private final String name;

  public Tool(String name){
    if (name == null || name.isEmpty())
      throw new IllegalArgumentException("name must not be null or empty");

    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString(){
    return String.format("Tool: %s ", name);
  }


  
}

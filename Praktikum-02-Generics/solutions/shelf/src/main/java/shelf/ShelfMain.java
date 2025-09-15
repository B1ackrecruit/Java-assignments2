package shelf;

import static java.lang.System.out;

public class ShelfMain {

  private static void printShelf(Shelf<?> shelf){

    for (ShelfItem item : shelf)
      out.println(item);

  }



  public static void main(String[] args) {
    Shelf<Book> bookShelf = new Shelf<>();
    bookShelf.setUpperLeft(new Book("Ullenbloom", "Java ist auch eine Insel", 1246));
    bookShelf.setUpperRight(new Book("Schuld", "Ferdinand von Schirach", 208));
    bookShelf.setLowerRight(new Book("Bibi und Tina", "Matthias von Bornstädt", 34));

    out.println("bookShelf:");
    printShelf(bookShelf);

    Shelf<Tool> toolShelf = new Shelf<>();
    toolShelf.setUpperLeft(new Tool("Schraubenzieher"));
    toolShelf.setLowerRight(new Tool("Säge"));

    out.println("toolShelf:");
    printShelf(toolShelf);

    // takeFrom
    Shelf<Book> newBookShelf = new Shelf<>();
    newBookShelf.takeFrom(bookShelf);

    out.println("newBookShelf:");
    printShelf(newBookShelf);

    Shelf<ShelfItem> generalShelf = new Shelf<>();
    generalShelf.takeFrom(newBookShelf);

    out.println("generalShelf:");
    printShelf(generalShelf);

    // max
    bookShelf.setUpperLeft(new Book("Ullenbloom", "Java ist auch eine Insel", 1246));
    bookShelf.setUpperRight(new Book("Schuld", "Ferdinand von Schirach", 208));
    bookShelf.setLowerRight(new Book("Bibi und Tina", "Matthias von Bornstädt", 34));

    Book maxPages = bookShelf.max((lhs,rhs) -> lhs.getPages()-rhs.getPages());


    
    out.println("maxPages: " + maxPages);

    // transferAndTrim
    Shelf.transferAndTrim(bookShelf, newBookShelf);
    Shelf.transferAndTrim(toolShelf, generalShelf);

    out.println("generalShelf:");
    printShelf(generalShelf);
    


  }
}

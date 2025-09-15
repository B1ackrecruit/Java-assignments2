package shelf;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShelfTest {

  private Book[] books;
  private Shelf<Book> bookShelf;

  @Before
  public void initializeBooks(){
    books = new Book[4];
    books[0] = new Book("Ullenbloom", "Java ist auch eine Insel", 1246);
    books[1] = new Book("Schuld", "Ferdinand von Schirach", 208);
    books[2] = new Book("Bibi und Tina: Pferdeabenteuer am Meer", "Matthias von Bornstädt", 34);
    books[3] = new Book("Alice im Wunderland", "Lews Carroll", 1246);
    bookShelf = new Shelf<>();

    bookShelf.setUpperLeft(books[0]);
    bookShelf.setUpperRight(books[1]);
    bookShelf.setLowerLeft(books[2]);
    bookShelf.setLowerRight(books[3]);
  }

  @Test
  public void shelfConstructorInitialize() {
    Shelf<ShelfItem> shelf = new Shelf<ShelfItem>();
    assertNull(shelf.getUpperLeft());
    assertNull(shelf.getUpperRight());
    assertNull(shelf.getLowerLeft());
    assertNull(shelf.getLowerRight());
  }

  @Test
  public void shelfSetIndexPosition() {
    Shelf<Book> shelf = new Shelf<>();

    for (int i = 0; i < 4; i++){
      shelf.set(i, books[i]);
    }

    assertSame(books[0], shelf.getUpperLeft());
    assertSame(books[1], shelf.getUpperRight());
    assertSame(books[2], shelf.getLowerLeft());
    assertSame(books[3], shelf.getLowerRight());

  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfSetIndexTooLargeIndex(){
    Shelf<Book> shelf = new Shelf<>();
    shelf.set(4, books[0]);
  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfSetIndexNegativeIndex(){
    Shelf<Book> shelf = new Shelf<>();
    shelf.set(-1, books[0]);
  }


  @Test
  public void shelfGetIndexPosition() {
    Shelf<Book> shelf = new Shelf<>();

    shelf.setUpperLeft(books[0]);
    shelf.setUpperRight(books[1]);
    shelf.setLowerLeft(books[2]);
    shelf.setLowerRight(books[3]);

    for (int i = 0; i < 4; i++){
      assertSame(books[i], shelf.get(i));
    }
  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfGetIndexTooLargeIndex(){
    Shelf<Book> shelf = new Shelf<>();
    shelf.get(4);
  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfGetIndexNegativeIndex(){
    Shelf<Book> shelf = new Shelf<>();
    shelf.get(-1);
  }

  @Test
  public void shelfIterator(){
    Shelf<Book> shelf = new Shelf<>();

    books[2] = null;

    for (int i = 0; i < 4; i++){
      shelf.set(i, books[i]);
    }

    int i = 0;
    for (Book book : shelf){
      assertSame(books[i++], book);
    }

  }

  @Test
  public void shelfIteratorBeyondLast() {
    Shelf<Book> shelf = new Shelf<>();
    Iterator<Book> it = shelf.iterator();
    for (int i = 0; i < 4; i++){
      assertTrue(it.hasNext());
      it.next();
    }

    assertFalse(it.hasNext());
  }

  @Test(expected=NoSuchElementException.class)
  public void shelfIteratorBeyondLastException() {
    Shelf<Book> shelf = new Shelf<>();
    Iterator<Book> it = shelf.iterator();
    for (int i = 0; i < 4; i++){
        it.next();
    }

    it.next();
  }

  @Test
  public void shelfTakeFrom(){
    Shelf<Book> shelf = new Shelf<Book>();
    shelf.takeFrom(bookShelf);

    for (int i = 0; i < 4; i++)
      assertSame(books[i], shelf.get(i));

    for (int i = 0; i < 4; i++)
      assertNull(bookShelf.get(i));
  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfTakeFromNull() {
    bookShelf.takeFrom(null);
  }

  @Test
  public void shelfMax() {
    bookShelf.set(2,null);

    Book max = bookShelf.max(
        (b1,b2) -> Integer.compare(b1.getPages(),b2.getPages()));

    assertTrue(max == books[0] || max == books[3]);
  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfMaxNull() {
    bookShelf.max(null);
  }

  @Test
  public void shelfTransferAndTrim() {
    bookShelf.set(1,null);
    bookShelf.set(2,null);

    Shelf<Book> shelf = new Shelf<>();

    Shelf.transferAndTrim(bookShelf, shelf);

    assertSame(books[0], shelf.get(0));
    assertSame(books[3], shelf.get(1));
    assertSame(null, shelf.get(2));
    assertSame(null, shelf.get(3));

    assertNull(bookShelf.get(0));
    assertNull(bookShelf.get(1));
    assertNull(bookShelf.get(2));
    assertNull(bookShelf.get(3));
  }

  @Test
  public void shelfTransferAndTrimNonEmpty() {

    Shelf<Book> shelf = new Shelf<>();

    shelf.set(2, books[1]);
    shelf.set(3, books[2]);

    bookShelf.set(1,null);
    bookShelf.set(2,null);

    Shelf.transferAndTrim(bookShelf, shelf);

    assertSame(books[0], shelf.get(0));
    assertSame(books[3], shelf.get(1));
    assertSame(null, shelf.get(2));
    assertSame(null, shelf.get(3));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void shelfTransferAndTrimFromNull() {
    Shelf.transferAndTrim(null, bookShelf);
  }

  @Test(expected=IllegalArgumentException.class)
  public void shelfTransferAndTrimToNull() {
    Shelf.transferAndTrim(bookShelf, null);
  }

}


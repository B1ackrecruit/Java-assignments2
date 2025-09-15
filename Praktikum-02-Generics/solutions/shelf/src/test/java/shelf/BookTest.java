package shelf;

import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {

  @Test 
  public void bookConstructorInitialize(){
    Book book = new Book("Alice im Wunderland", "Lewis Carroll", 234);
    assertEquals("Alice im Wunderland", book.getTitle());
    assertEquals("Lewis Carroll", book.getAuthor());
    assertEquals(234, book.getPages());
  }


  @Test(expected=IllegalArgumentException.class)
  public void bookConstructorNullTitle(){
    new Book(null, "Lewis Carroll", 234);
  }

  @Test(expected=IllegalArgumentException.class)
  public void bookConstructorEmptyTitle(){
    new Book("", "Lewis Carroll", 234);
  }

  @Test(expected=IllegalArgumentException.class)
  public void bookConstructorNullAuthor(){
    new Book("Alice im Wunderland", null, 234);
  }

  @Test(expected=IllegalArgumentException.class)
  public void bookConstructorEmptyAuthor(){
    new Book("Alice im Wunderland", "", 234);
  }

  @Test(expected=IllegalArgumentException.class)
  public void bookConstructorZeroPages(){
    new Book("Alice im Wunderland", "Lewis Carroll", 0);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void bookConstructorNegativePages(){
    new Book("Alice im Wunderland", "Lewis Carroll", -5);
  }

  @Test
  public void bookConstructorInvalid(){

    assertThrows("...",
        IllegalArgumentException.class,
        () ->  new Book(null, "Lewis Carroll", 234) );

    assertThrows("...",
        IllegalArgumentException.class,
        () ->  new Book("", "Lewis Carroll", 234) );

    assertThrows("...",
        IllegalArgumentException.class,
        () ->  new Book("Alice im Wunderland", "Lewis Carroll", -234) );

  }
  
}

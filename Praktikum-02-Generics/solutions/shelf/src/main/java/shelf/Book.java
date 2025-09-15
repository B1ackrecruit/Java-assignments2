package shelf;

public class Book extends ShelfItem {


  private final String title;
  private final String author;
  private final int pages;

  public Book(String title, String author, int pages){
    if (title == null || title.isEmpty())
      throw new IllegalArgumentException("title must not be null or empty");

    if (author == null || author.isEmpty())
      throw new IllegalArgumentException("author must not be null or empty");

    if (pages <= 0)
      throw new IllegalArgumentException("pages must at least be 1");

    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  public int getPages() {
    return pages;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return String.format("Book: %s, %s, %d pages", title, author, pages);
  }

}

package com.kgisl.springbootbook;

public class BookBuilder {
  // private int id;
  // private String title;
  // private String author;
  // private float price;

  private Book book = new Book();

  /**
   * @param id the id to set
   */
  public BookBuilder setId(int id) {
    book.setId(id);
    return this;
  }

  /**
   * @param title the title to set
   */
  public BookBuilder setTitle(String title) {
    book.setTitle(title);
    return this;
  }

  /**
   * @param author the author to set
   */
  public BookBuilder setAuthor(String author) {
    book.setAuthor(author);;
    return this;
  }

  /**
   * @param price the price to set
   */
  public BookBuilder setPrice(float price) {
    book.setPrice(price);
    return this;
  }

  public Book getbook() {
		return book;
	}

}
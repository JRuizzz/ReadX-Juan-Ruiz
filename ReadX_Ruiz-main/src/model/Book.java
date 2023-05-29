package model;

import java.util.Calendar;

/**
 * The Book class represents a book, which is a type of library product.
 * It extends the BiblioProducts class and adds specific properties such as a short review, genre, and number of sold books.
 */
public class Book extends BiblioProducts {
    
    private String shortReview;
    private Genre genre;
    private int numSoldBooks;
    
    /**
     * Constructor for the Book class.
     * @param name the name of the book
     * @param id the ID of the book
     * @param numberPages the number of pages of the book
     * @param postDate the post date of the book
     * @param value the value of the book
     * @param readedPages the number of read pages of the book
     * @param URL the URL of the book
     * @param shortReview a short review of the book
     * @param genre the genre of the book
     * @param numSoldBooks the number of sold books
     */
    public Book(String name, String id, int numberPages, Calendar postDate, int value, int readedPages, String URL, String shortReview, Genre genre, int numSoldBooks) {
        super(name, id, numberPages, postDate, value, readedPages, URL);
        this.shortReview = shortReview;
        this.genre = genre;
        this.numSoldBooks = numSoldBooks;
    }

    /**
     * Copy constructor for the Book class.
     * @param bookToCopy the book to copy
     */
    public Book(Book bookToCopy) {
        super(bookToCopy.getName(), bookToCopy.getId(), bookToCopy.getNumberPages(), bookToCopy.getPostDate(), bookToCopy.getValue(), bookToCopy.getReadedPages(), bookToCopy.getURL());
        this.shortReview = bookToCopy.getShortReview();
        this.genre = bookToCopy.getGenre();
        this.numSoldBooks = bookToCopy.getNumSoldBooks();
    }
    
    /**
     * Returns the short review of the book.
     * @return the short review of the book
     */
    public String getShortReview() {
        return shortReview;
    }

    /**
     * Sets the short review of the book.
     * @param shortReview the short review to set
     */
    public void setShortReview(String shortReview) {
        this.shortReview = shortReview;
    }

    /**
     * Returns the genre of the book.
     * @return the genre of the book
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     * @param genre the genre to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    /**
     * Returns the number of sold books.
     * @return the number of sold books
     */
    public int getNumSoldBooks() {
        return numSoldBooks;
    }

    /**
     * Sets the number of sold books.
     * @param numSoldBooks the number of sold books to set
     */
    public void setNumSoldBooks(int numSoldBooks) {
        this.numSoldBooks = numSoldBooks;
    }
}

package model;

/**
 * The Buyable interface represents a buyable item in the library.
 * It defines methods for buying a book or a magazine.
 */
public interface Buyable {
    
    /**
     * Buys a book.
     * @param p the book to buy
     * @return true if the book was successfully bought, false otherwise
     */
    boolean buyBook(BiblioProducts p);
    
    /**
     * Buys a magazine.
     * @param p the magazine to buy
     * @return true if the magazine was successfully bought, false otherwise
     */
    boolean buyMagazine(BiblioProducts p);

}

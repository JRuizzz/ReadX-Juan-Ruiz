package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * The abstract class BiblioProducts is a base class for library products.
 * It contains basic information such as name, ID, number of pages, post date, value, read pages, and URL.
 */
public abstract class BiblioProducts {
    
    private String name;
    private String id;
    private int numberPages;
    private Calendar postDate;
    private int value;
    private int readedPages;
    private String URL;
    private DateFormat formatter;
    
    /**
     * Constructor for the BiblioProducts class.
     * @param name the name of the product
     * @param id the ID of the product
     * @param numberPages the number of pages of the product
     * @param postDate the post date of the product
     * @param value the value of the product
     * @param readedPages the number of read pages of the product
     * @param URL the URL of the product
     */
    public BiblioProducts(String name, String id, int numberPages, Calendar postDate, int value, int readedPages, String URL) {
        this.name = name;
        this.id = id;
        this.numberPages = numberPages;
        this.postDate = postDate;
        this.value = value;
        this.readedPages = readedPages;
        this.URL = URL;
        this.formatter = new SimpleDateFormat("dd/M/yyyy");
    }
    
    /**
     * Returns the name of the product.
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the product.
     * @return the ID of the product
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     * @param id the ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the number of pages of the product.
     * @return the number of pages of the product
     */
    public int getNumberPages() {
        return numberPages;
    }

    /**
     * Sets the number of pages of the product.
     * @param numberPages the number of pages to set
     */
    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    /**
     * Returns the post date of the product.
     * @return the post date of the product
     */
    public Calendar getPostDate() {
        return postDate;
    }

    /**
     * Returns the formatted post date of the product.
     * @return the formatted post date of the product
     */
    public String getPostDateFormated() {
        return formatter.format(this.postDate.getTime());
    }

    /**
     * Sets the post date of the product.
     * @param postDate the post date to set
     */
    public void setPostDate(Calendar postDate) {
        this.postDate = postDate;
    }

    /**
     * Returns the number of read pages of the product.
     * @return the number of read pages of the product
     */
    public int getReadedPages() {
        return readedPages;
    }

    /**
     * Sets the number of read pages of the product.
     * @param readedPages the number of read pages to set
     */
    public void setReadedPages(int readedPages) {
        this.readedPages = readedPages;
    }

    /**
     * Returns the URL of the product.
     * @return the URL of the product
     */
    public String getURL() {
        return URL;
    }

    /**
     * Sets the URL of the product.
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * Returns the value of the product.
     * @return the value of the product
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the product.
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
}

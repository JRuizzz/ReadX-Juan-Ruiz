package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * The User class represents a user in the library system.
 */
public abstract class User implements Buyable {

    private String nameUser;
    private String cc;
    private Calendar vinculationDate;
    private DateFormat formatter;
    private ArrayList<BiblioProducts[][]> library;
    private ArrayList<Invoice> invoices;

    /**
     * Constructs a new User object with the specified properties.
     *
     * @param nameUser        the name of the user
     * @param cc              the ID of the user
     * @param vinculationDate the vinculation date of the user
     */
    public User(String nameUser, String cc, Calendar vinculationDate) {
        this.nameUser = nameUser;
        this.cc = cc;
        this.vinculationDate = Calendar.getInstance();
        this.formatter = new SimpleDateFormat("dd/M/yyyy");
        this.library = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * Sets the name of the user.
     *
     * @param nameUser the name of the user
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * Returns the ID of the user.
     *
     * @return the ID of the user
     */
    public String getCc() {
        return cc;
    }

    /**
     * Sets the ID of the user.
     *
     * @param cc the ID of the user
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Returns the vinculation date of the user.
     *
     * @return the vinculation date of the user
     */
    public Calendar getVinculationDate() {
        return vinculationDate;
    }

    /**
     * Sets the vinculation date of the user.
     *
     * @param vinculationDate the vinculation date of the user
     */
    public void setVinculationDate(Calendar vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    /**
     * Returns the formatted vinculation date of the user.
     *
     * @return the formatted vinculation date of the user
     */
    public String getVinculationDateFormated() {
        return formatter.format(this.vinculationDate.getTime());
    }

    /**
     * Returns the library of the user.
     *
     * @return the library of the user
     */
    public ArrayList<BiblioProducts[][]> getLibrary() {
        return library;
    }

    /**
     * Sets the library of the user.
     *
     * @param library the library of the user
     */
    public void setLibrary(ArrayList<BiblioProducts[][]> library) {
        this.library = library;
    }

    /**
     * Returns the invoices of the user.
     *
     * @return the invoices of the user
     */
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Sets the invoices of the user.
     *
     * @param invoices the invoices of the user
     */
    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    /**
     * Abstract method for buying a book.
     *
     * @param biblioProductToAdd the book to buy
     * @return true if the book was bought successfully, false otherwise
     */
    public abstract boolean buyBook(BiblioProducts biblioProductToAdd);

    /**
     * Abstract method for buying a magazine.
     *
     * @param biblioProductToAdd the magazine to buy
     * @return true if the magazine was bought successfully, false otherwise
     */
    public abstract boolean buyMagazine(BiblioProducts biblioProductToAdd);

    /**
     * Abstract method for accumulating read pages of books.
     *
     * @return the total number of read pages of books
     */
    public abstract int bookAcomulateReadPages();

    /**
     * Abstract method for accumulating read pages of magazines.
     *
     * @return the total number of read pages of magazines
     */
    public abstract int MagazineacomulateReadPages();

    /**
     * Abstract method for getting the subscribed magazine.
     *
     * @return the subscribed magazine
     */
    public abstract String getSuscribedMagazine();

    /**
     * Abstract method for getting the library matrix.
     *
     * @return the library matrix as a string
     */
    public abstract String getMatrix();

    /**
     * Abstract method for canceling a subscription.
     *
     * @param option the subscription to cancel
     * @return true if the subscription was canceled successfully, false otherwise
     */
    public abstract boolean cancelSuscription(BiblioProducts option);

    /**
     * Abstract method for a reading session.
     *
     * @param name         the name of the reading material
     * @param currentPage  the current page being read
     * @param numberPages  the total number of pages in the reading material
     * @return a message with information about the reading session
     */
    public abstract String readingSession(String name, int currentPage, int numberPages);

    /**
     * Adds an invoice to the user's list of invoices.
     *
     * @param invoice the invoice to add
     */
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}

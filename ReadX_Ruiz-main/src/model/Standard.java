package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * The Standard class represents a standard user in the library system.
 */
public class Standard extends User {

    private BiblioProducts[] listOfProducts;

    /**
     * Constructs a new Standard object with the specified properties.
     *
     * @param nameUser        the name of the user
     * @param cc              the ID of the user
     * @param vinculationDate the vinculation date of the user
     */
    public Standard(String nameUser, String cc, Calendar vinculationDate) {
        super(nameUser, cc, vinculationDate);
        listOfProducts = new BiblioProducts[7];
    }

    @Override
    public boolean buyBook(BiblioProducts biblioProductToAdd) {
        if (verifyBook()) {
            for (int i = 0; i < listOfProducts.length; i++) {
                if (listOfProducts[i] == null) {
                    listOfProducts[i] = biblioProductToAdd;
                    createLibrary();
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean buyMagazine(BiblioProducts biblioProductToAdd) {
        if (verifyMagazine()) {
            for (int i = 0; i < listOfProducts.length; i++) {
                if (listOfProducts[i] == null) {
                    listOfProducts[i] = biblioProductToAdd;
                    createLibrary();
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verifies if the user can buy more books.
     *
     * @return true if the user can buy more books, false otherwise
     */
    public boolean verifyBook() {
        int counterBook = 0;
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] instanceof Book) {
                counterBook++;
            }
        }
        return counterBook < 5;
    }

    /**
     * Verifies if the user can buy more magazines.
     *
     * @return true if the user can buy more magazines, false otherwise
     */
    public boolean verifyMagazine() {
        int counterMagazine = 0;
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] instanceof Magazine) {
                counterMagazine++;
            }
        }
        return counterMagazine < 2;
    }

    @Override
    public int bookAcomulateReadPages() {
        int acom = 0;

        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] instanceof Book) {
                acom += listOfProducts[i].getReadedPages();
            }
        }

        return acom;
    }

    @Override
    public int MagazineacomulateReadPages() {
        int acom = 0;

        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] instanceof Magazine) {
                acom += listOfProducts[i].getReadedPages();
            }
        }

        return acom;
    }

    @Override
    public String getSuscribedMagazine() {
        String msg = "";
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] instanceof Magazine) {
                msg += "\n" + (i + 1) + ". " + listOfProducts[i].getName() + "\n";
            }
        }
        return msg;
    }

    /**
     * Organizes the products in the library based on their post dates.
     */
    public void organizeProducts() {
        for (int i = 1; i < listOfProducts.length; i++) {
            for (int j = 0; j < i; j++) {
                if (listOfProducts[i] != null && listOfProducts[j] != null
                        && listOfProducts[i].getPostDate().compareTo(listOfProducts[j].getPostDate()) < 0) {
                    BiblioProducts temp = listOfProducts[i];
                    for (int k = i; k > j; k--) {
                        listOfProducts[k] = listOfProducts[k - 1];
                    }
                    listOfProducts[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * Creates the library matrix based on the organized products.
     */
    public void createLibrary() {
        organizeProducts();
        ArrayList<BiblioProducts[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < (((int) listOfProducts.length / 25) + 1); h++) {
            BiblioProducts[][] matrix = new BiblioProducts[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (cont >= listOfProducts.length) break;
                    matrix[i][j] = listOfProducts[cont];
                    cont++;
                }
            }
            temp.add(matrix);
        }
        setLibrary(temp);
    }

    @Override
    public String getMatrix() {
        String msg = "[ ___ ][  0  ][  1  ][  2  ][  3  ][  4  ]\n";
        for (int i = 0; i < getLibrary().size(); i++) {
            for (int j = 0; j < getLibrary().get(i).length; j++) {
                msg += "[  " + j + "  ]";
                for (int h = 0; h < getLibrary().get(i).length; h++) {
                    if (getLibrary().get(i)[j][h] != null) {
                        msg += "[ " + getLibrary().get(i)[j][h].getId() + " ]";
                    } else {
                        msg += "[ ___ ]";
                    }
                }
                msg += "\n";
            }
            msg += "\n";
        }
        return msg;
    }

    @Override
    public boolean cancelSuscription(BiblioProducts option) {
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] == option) {
                listOfProducts[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String readingSession(String name, int currentPage, int numberPages) {
        String msg = "";
        msg += "\nReading session in progress:";
        msg += "\nReading: " + name;
        msg += "\nReading page: " + currentPage + " of " + numberPages;
        msg += "\nType A to go to the previous page \nType S to go to the next page \nType B to go to the bibliotec";
        return msg;
    }
}

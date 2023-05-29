package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * The Premium class represents a premium user in the library system.
 */
public class Premium extends User {

    private ArrayList<BiblioProducts> products;

    /**
     * Constructs a new Premium object with the specified properties.
     *
     * @param nameUser        the name of the user
     * @param cc              the ID of the user
     * @param vinculationDate the vinculation date of the user
     */
    public Premium(String nameUser, String cc, Calendar vinculationDate) {
        super(nameUser, cc, vinculationDate);
        products = new ArrayList<BiblioProducts>();
    }

    @Override
    public boolean buyBook(BiblioProducts biblioProductToAdd) {
        products.add(biblioProductToAdd);
        createMatrix();
        return true;
    }

    @Override
    public boolean buyMagazine(BiblioProducts biblioProductToAdd) {
        products.add(biblioProductToAdd);
        createMatrix();
        return true;
    }

    @Override
    public int bookAcomulateReadPages() {
        int acom = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Book) {
                acom += products.get(i).getReadedPages();
            }
        }

        return acom;
    }

    @Override
    public int MagazineacomulateReadPages() {
        int acom = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Magazine) {
                acom += products.get(i).getReadedPages();
            }
        }

        return acom;
    }

    @Override
    public String getSuscribedMagazine() {
        String msg = "";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Magazine) {
                msg += "\n" + (i + 1) + ". " + products.get(i).getName() + "\n";
            }
        }
        return msg;
    }

    /**
     * Organizes the products in chronological order by their post date.
     */
    public void organizeProducts() {
        for (int i = 1; i < products.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (products.get(i).getPostDate().compareTo(products.get(j).getPostDate()) < 0) {
                    products.add(j, products.remove(i));
                    break;
                }
            }
        }
    }

    /**
     * Creates a matrix representation of the user's library based on the ordered products.
     */
    public void createMatrix() {
        organizeProducts();
        ArrayList<BiblioProducts[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < (((int) products.size() / 25) + 1); h++) {
            BiblioProducts[][] matrix = new BiblioProducts[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {
                    if (cont >= products.size()) break;
                    matrix[i][j] = products.get(cont);
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
                for (int j2 = 0; j2 < getLibrary().get(i).length; j2++) {
                    if (getLibrary().get(i)[j][j2] != null) {
                        msg += "[ " + getLibrary().get(i)[j][j2].getId() + " ]";
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
    public boolean cancelSuscription(BiblioProducts optionMG) {
        products.remove(optionMG);
        return true;
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

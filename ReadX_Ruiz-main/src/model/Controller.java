package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


/**
 * This class represents a controller for managing biblio products, users, and invoices.
 */
public class Controller {
    private ArrayList<BiblioProducts> listOfBiblioProducts;
    private ArrayList<User> listOfUser;
    private ArrayList<Invoice> listOfInvoices;

    /**
     * Constructs a new Controller object.
     * Initializes the lists of users, biblio products, and invoices.
     * Calls the testCases() method to perform initial test cases.
     */
    public Controller() {
        listOfUser = new ArrayList<>();
        listOfBiblioProducts = new ArrayList<>();
        listOfInvoices = new ArrayList<>();
        testCases();
    }

     /**
     * Performs initial test cases by creating users and biblio products and adding them to the respective lists.
     */
    public void testCases() {
        Calendar vinculationDate = Calendar.getInstance();

        User firstTestUser = new Standard("Juan", "123", vinculationDate);

        User SecondTestUser = new Premium("Valentina", "124", vinculationDate);

        BiblioProducts firstTestBook = new Book("Supra", "A11", 6, new GregorianCalendar(2023, 1, 16), 50, 0, "url.com", "It's a supra", Genre.FANTASY, 0);

        BiblioProducts firstTestMagazine = new Magazine("APO", "16F", 6, new GregorianCalendar(2020, 1, 14), 2, "url.com", 0, Category.DESIGN, "Monthly", 0);

        listOfUser.add(firstTestUser);
        listOfUser.add(SecondTestUser);
        listOfBiblioProducts.add(firstTestBook);
        listOfBiblioProducts.add(firstTestMagazine);
    }

    /**
     * Generates a random HEXAID consisting of three hexadecimal digits.
     *
     * @return The generated HEXAID as a string.
     */
    public String generateHEXAID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(16);
            sb.append(Integer.toHexString(randomNumber));
        }

        return sb.toString().toUpperCase();
    }

    /**
    * Generates a random ALFAID consisting of three alphanumeric characters.
    *
    * @return The generated ALFAID as a string.
    */
    public String generateALFAID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final int ID_LENGTH = 3;

        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    /**
    * Registers a new user with the specified name, ID number, vinculation date, and user type.
    *
    * @param nameUser         The name of the user.
    * @param cc               The ID number of the user.
    * @param vinculationDate  The vinculation date of the user.
    * @param optionUser       The user type option (1 for Standard, 2 for Premium).
    * @return                 True if the user is successfully registered, false otherwise.
    */
    public boolean registerUser(String nameUser, String cc, Calendar vinculationDate, int optionUser) {
        User newUser = null;

        if (optionUser == 1) {
            newUser = new Standard(nameUser, cc, vinculationDate);
        } else if (optionUser == 2) {
            newUser = new Premium(nameUser, cc, vinculationDate);
        }

        return listOfUser.add(newUser);
    }


    /**
     * Registers a new biblio product with the specified details.
     *
     * @param name           The name of the biblio product.
     * @param id             The ID of the biblio product.
     * @param numberPages    The number of pages in the biblio product.
     * @param shortReview    The short review of the biblio product.
     * @param genres         The genre option (1 for Fiction/Science, 2 for Fantasy, 3 for Historical Novel).
     * @param URL            The URL of the biblio product.
     * @param value          The value of the biblio product.
     * @param numSoldBooks   The number of sold books (applicable only for books).
     * @param optionProducts The product type option (1 for Book, 2 for Magazine).
     * @param yearPostDate   The year of the post date.
     * @param monthPostDate  The month of the post date.
     * @param dayPostDate    The day of the post date.
     * @param readedPages    The number of pages read (applicable only for books).
     * @param categorys      The category option (1 for Varieties, 2 for Design, 3 for Scientist).
     * @param issPeriod      The issue period of the magazine (applicable only for magazines).
     * @param activeSubs     The number of active subscriptions (applicable only for magazines).
     * @return               True if the biblio product is successfully registered, false otherwise.
     */
    public boolean registerBiblioProducts(String name, String id, int numberPages, String shortReview, int genres, String URL, int value, int numSoldBooks, int optionProducts, int yearPostDate, int monthPostDate, int dayPostDate, int readedPages, int categorys, String issPeriod, int activeSubs) {
        Genre genre = Genre.FICTION_SCIENCE;
        if (genres == 2) {
            genre = Genre.FANTASY;
        } else if (genres == 3) {
            genre = Genre.HISTORICAL_NOVEL;
        }

        Category category = Category.VARIETIES;
        if (categorys == 2) {
            category = Category.DESIGN;
        } else if (categorys == 3) {
            category = Category.SCIENTIST;
        }

        BiblioProducts newProduct = null;

        Calendar postDate = new GregorianCalendar(yearPostDate, (monthPostDate - 1), dayPostDate);

        if (optionProducts == 1) {
            newProduct = new Book(name, id, numberPages, postDate, value, readedPages, URL, shortReview, genre, numSoldBooks);
        } else if (optionProducts == 2) {
            newProduct = new Magazine(name, id, numberPages, postDate, value, URL, readedPages, category, issPeriod, activeSubs);
        }

        return listOfBiblioProducts.add(newProduct);
    }

    
    /**
     * Modifies the details of a book based on the specified option and new values.
     *
     * @param option            The option to select the book to modify.
     * @param newName           The new name of the book.
     * @param newId             The new ID of the book.
     * @param newNumberPages    The new number of pages of the book.
     * @param newShortReview    The new short review of the book.
     * @param newGenres         The new genre option (1 for Fiction/Science, 2 for Fantasy, 3 for Historical Novel).
     * @param newURL            The new URL of the book.
     * @param newValue          The new value of the book.
     * @param newYearPostDate   The new year of the post date.
     * @param newMonthPostDate  The new month of the post date.
     * @param newDayPostDate    The new day of the post date.
     * @return                  True if the book is successfully modified, false otherwise.
     */
    public boolean modifyBook(int option, String newName, String newId, int newNumberPages, String newShortReview, int newGenres, String newURL, int newValue, int newYearPostDate, int newMonthPostDate, int newDayPostDate) {
        if (option >= listOfBiblioProducts.size()) {
            return false;
        }

        Genre genre = Genre.FICTION_SCIENCE;
        if (newGenres == 2) {
            genre = Genre.FANTASY;
        } else if (newGenres == 3) {
            genre = Genre.HISTORICAL_NOVEL;
        }

        Calendar newPostDate = new GregorianCalendar(newYearPostDate, (newMonthPostDate - 1), newDayPostDate);
        BiblioProducts book = listOfBiblioProducts.get(option);

        book.setId(newId);
        book.setName(newName);
        book.setNumberPages(newNumberPages);
        ((Book) book).setShortReview(newShortReview);
        ((Book) book).setGenre(genre);
        book.setURL(newURL);
        book.setValue(newValue);
        book.setPostDate(newPostDate);

        return true;
    }

    /**
     * Modifies the details of a magazine based on the specified option and new values.
     *
     * @param option            The option to select the magazine to modify.
     * @param newName           The new name of the magazine.
     * @param newId             The new ID of the magazine.
     * @param newNumberPages    The new number of pages of the magazine.
     * @param newIssPeriod      The new issue period of the magazine.
     * @param newCategorys      The new category option (1 for Varieties, 2 for Design, 3 for Scientist).
     * @param newURL            The new URL of the magazine.
     * @param newValue          The new value of the magazine.
     * @param newYearPostDate   The new year of the post date.
     * @param newMonthPostDate  The new month of the post date.
     * @param newDayPostDate    The new day of the post date.
     * @return                  True if the magazine is successfully modified, false otherwise.
     */
    public boolean modifyMagazine(int option, String newName, String newId, int newNumberPages, String newIssPeriod, int newCategorys, String newURL, int newValue, int newYearPostDate, int newMonthPostDate, int newDayPostDate) {
        if (option >= listOfBiblioProducts.size()) {
            return false;
        }

        Category category = Category.VARIETIES;
        if (newCategorys == 2) {
            category = Category.DESIGN;
        } else if (newCategorys == 3) {
            category = Category.SCIENTIST;
        }

        Calendar newPostDate = new GregorianCalendar(newYearPostDate, (newMonthPostDate - 1), newDayPostDate);
        BiblioProducts magazine = listOfBiblioProducts.get(option);

        magazine.setId(newId);
        magazine.setName(newName);
        magazine.setNumberPages(newNumberPages);
        ((Magazine) magazine).setIssPeriod(newIssPeriod);
        ((Magazine) magazine).setCategory(category);
        magazine.setURL(newURL);
        magazine.setValue(newValue);
        magazine.setPostDate(newPostDate);

        return true;
    }

    
    /**
     * Deletes a book from the list of bibliographic products based on the specified index.
     *
     * @param bookIndex The index of the book to delete.
     * @return          True if the book is successfully deleted, false otherwise.
     */
    public boolean deleteBooks(int bookIndex) {
        if (bookIndex >= listOfBiblioProducts.size()) {
            return false;
        }
        
        listOfBiblioProducts.remove(bookIndex);
        return true;
    }

    /**
     * Deletes a magazine from the list of bibliographic products based on the specified index.
     *
     * @param magazineIndex The index of the magazine to delete.
     * @return              True if the magazine is successfully deleted, false otherwise.
     */
    public boolean deleteMagazines(int magazineIndex) {
        if (magazineIndex >= listOfBiblioProducts.size()) {
            return false;
        }

        listOfBiblioProducts.remove(magazineIndex);
        return true;
    }

    /**
     * Prints the details of an invoice.
     *
     * @param invoice The invoice object to print.
     */
    public void printInvoice(Invoice invoice) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
        String date = dateFormat.format(invoice.getOperationDate().getTime());
        double amount = invoice.getAmount();
        String nameProduct = invoice.getNameProduct();

        System.out.println("\n-----------------");
        System.out.println("\nInvoice Details:");
        System.out.println("\n-----------------");
        System.out.println("\nProduct name: " + nameProduct);
        System.out.println("\nDate: " + date);
        System.out.println("\nAmount: $" + amount + " USD");
        System.out.println("\n------------------");
    }

    /**
     * Buys a book for a user based on the specified options.
     *
     * @param optionBUY   The index of the book to buy.
     * @param optionUser  The index of the user who is buying the book.
     * @return            True if the book is successfully bought, false otherwise.
     */
    public boolean buyBook(int optionBUY, int optionUser) {
        if (optionBUY >= listOfBiblioProducts.size() || optionUser >= listOfUser.size()) {
            return false;
        }

        User user = listOfUser.get(optionUser);
        BiblioProducts product = listOfBiblioProducts.get(optionBUY);

        if (product instanceof Book) {
            boolean buyProduct = user.buyBook(product);
            if (buyProduct) {
                double amount = product.getValue();
                Calendar operationDate = Calendar.getInstance();
                String nameProduct = product.getName();
                Invoice invoice = new Invoice(nameProduct, operationDate, amount);
                listOfInvoices.add(invoice);
                user.addInvoice(invoice);
                printInvoice(invoice);
                return true;
            }
        }

        return false;
    }

    /**
     * Buys a magazine for a user based on the specified options.
     *
     * @param optionBUY   The index of the magazine to buy.
     * @param optionUser  The index of the user who is buying the magazine.
     * @return            True if the magazine is successfully bought, false otherwise.
     */
    public boolean buyMagazine(int optionBUY, int optionUser) {
        if (optionBUY >= listOfBiblioProducts.size() || optionUser >= listOfUser.size()) {
            return false;
        }

        User user = listOfUser.get(optionUser);
        BiblioProducts product = listOfBiblioProducts.get(optionBUY);

        if (product instanceof Magazine) {
            boolean buyProduct = user.buyMagazine(product);
            if (buyProduct) {
                double amount = product.getValue();
                Calendar operationDate = Calendar.getInstance();
                String nameProduct = product.getName();
                Invoice invoice = new Invoice(nameProduct, operationDate, amount);
                listOfInvoices.add(invoice);
                user.addInvoice(invoice);
                printInvoice(invoice);
                return true;
            }
        }

        return false;
    }
    
    /**
     * Consults the library for a specific user and returns the library information as a string.
     *
     * @param optionUser  The index of the user to consult the library for.
     * @return            The library information for the user.
     */

    public String consultLibrary(int optionUser){
        String msg = "";
        User user = listOfUser.get(optionUser);
        msg += "Biblioteca de "+ user.getNameUser();
        msg += "\n" + listOfUser.get(optionUser).getMatrix();

        return msg;
    }

    /**
     * Simulates a reading session for a user and returns a message with the session details and any additional information.
     *
     * @param decisionUser  The ID of the bibliographic product being read.
     * @param optionUser    The index of the user performing the reading session.
     * @param option        The reading session option (e.g., "next", "previous", "go-to").
     * @param currentPage   The current page being read.
     * @param cont          The count of reading sessions.
     * @return              The message with the session details and additional information.
     */
    public String readingSession(String decisionUser, int optionUser, String option, int currentPage, int cont) {
        String msg = "";
        int cont1 = 0;
        int numberPages = 0;
        Random publicity = new Random();
        String name = "";
        
        for (int i = 0; i < listOfBiblioProducts.size(); i++) {
            if (listOfBiblioProducts.get(i).getId().equals(decisionUser)) {
                name = listOfBiblioProducts.get(i).getName();
                listOfBiblioProducts.get(i).getReadedPages();
                numberPages = listOfBiblioProducts.get(i).getNumberPages();
            }
        }
        currentPage = updateCurrentPage(option, currentPage, numberPages);
        
        for (int i = 0; i < listOfUser.size(); i++) {
            if (listOfUser.get(i).getCc().equals(listOfUser.get(optionUser).getCc())) {
                if (listOfUser.get(i) instanceof Standard) {
                    msg += ((Standard) listOfUser.get(i)).readingSession(name, currentPage, numberPages);
                    if (cont % 5 == 0) {
                        cont1 = publicity.nextInt(3);
                        if (cont1 == 0) {
                            msg += "Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!";
                        } else if (cont1 == 1) {
                            msg += "Now your pets have a favorite app: Laika. The best products for your furry.";
                        } else if (cont1 == 2) {
                            msg += "We are celebrating our anniversary! Visit your nearest Éxito and be surprised with the best offers.";
                        }
                    }
                } else if (listOfUser.get(i) instanceof Premium) {
                    msg += ((Premium) listOfUser.get(i)).readingSession(name, currentPage, numberPages);
                }
            }
        }
        
        return msg;
    }
    /**
     * Updates the current page based on the given option.
     *
     * @param option      The reading session option (e.g., "previous" or "next").
     * @param currentPage The current page being read.
     * @param numberPages The total number of pages in the book.
     * @return The updated current page.
     */
    public int updateCurrentPage(String option, int currentPage, int numberPages) {
        if (option.equalsIgnoreCase("a")) {
            if (currentPage > 1) {
                currentPage--;
            } else {
                System.out.println("\nYou are already on the first page.");
            }
        } else if (option.equalsIgnoreCase("s")) {
            if (currentPage < numberPages) {
                currentPage++;
            } else {
                System.out.println("\nYou have reached the last page.");
            }
        }
        return currentPage;
    }
    
    /**
     * Retrieves the number of pages for the product with the given code.
     *
     * @param productCode The code of the product.
     * @return The number of pages of the product, or 0 if not found.
     */
    public int getNumberOfPages(String productCode) {
        for (BiblioProducts product : listOfBiblioProducts) {
            if (product.getId().equals(productCode)) {
                return product.getNumberPages();
            }
        }
        return 0;
    }

    /**
     * Generates the first report by accumulating the total number of read pages for books and magazines.
     *
     * @return The report message with the accumulated read pages for books and magazines.
     */
    public String firstReport() {
        int acomBook = 0;
        int acomMagazine = 0;

        for (int i = 0; i < listOfUser.size(); i++) {
            acomBook += listOfUser.get(i).bookAcomulateReadPages();
        }
        
        for (int i = 0; i < listOfUser.size(); i++) {
            acomMagazine += listOfUser.get(i).MagazineacomulateReadPages();
        }

        String msg = "";
        msg += "Book: " + acomBook + "\n";
        msg += "Magazine: " + acomMagazine + "\n";

        return msg;
    }
    public String secondReport() {
        String msg = "";
        for (User user : listOfUser ) {
            Genre mostReadBookGenre = user.mostReadGenre();
            Category mostReadMagazineCategory = user.mostReadCategory();
            int numBook = user.bookAcomulateReadPages();
            int numMagazine = user.MagazineacomulateReadPages();
            
            msg+="\nMost Read Book Genre: " + mostReadBookGenre;
            msg+="\nNumber of Pages Read of the book: " + numBook;
            msg+="\nMost Read Magazine Category: " + mostReadMagazineCategory;
            msg+="\nNumber of Pages Read of the Magazine: " + numMagazine;
            break;
        }
        return msg;
    }
    public String thirdReport() {
        String msg = "";
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        double value1 = 0;
        double value2 = 0;
        double value3 = 0;
    
        for (BiblioProducts product : listOfBiblioProducts) {
            if (product instanceof Book) {
                Book book = (Book) product;
                Genre genre = book.getGenre();
                double value = book.getValue() * book.getNumSoldBooks();
    
                if (genre == Genre.FANTASY) {
                    cont1++;
                    value1 += value;
                } else if (genre == Genre.HISTORICAL_NOVEL) {
                    cont2++;
                    value2 += value;
                } else if (genre == Genre.FICTION_SCIENCE) {
                    cont3++;
                    value3 += value;
                }
            }
        }
    
        msg += "\nThe number of books sold in the: ";
        msg += "\nFantasy " + cont1;
        msg += "\nHistorical Novel " + cont2;
        msg += "\nScience Fiction " + cont3;
    
        msg += "\n\nThe total value: ";
        msg += "\nFantasy: " + value1;
        msg += "\nHistorical Novel: " + value2;
        msg += "\nScience Fiction: " + value3;
    
        return msg;
    }
    
    /**
     * Calculates the number of active subscriptions and their total value by magazine category.
     *
     * @return Returns a formatted message containing the number of active subscriptions and their total value by category.
     */
    public String fourthReport() {
        String msg = "";
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        double value1 = 0;
        double value2 = 0;
        double value3 = 0;
    
        for (BiblioProducts product : listOfBiblioProducts) {
            if (product instanceof Magazine) {
                Magazine magazine = (Magazine) product;
                Category category = magazine.getCategory();
                double value = magazine.getValue() * magazine.getActiveSubs();
    
                if (category == Category.DESIGN) {
                    cont1++;
                    value1 += value;
                } else if (category == Category.SCIENTIST) {
                    cont2++;
                    value2 += value;
                } else if (category == Category.VARIETIES) {
                    cont3++;
                    value3 += value;
                }
            }
        }
    
        msg += "\nThe number of magazines sold in the: ";
        msg += "\nDesign " + cont1;
        msg += "\nScientific " + cont2;
        msg += "\nVarieties " + cont3;
    
        msg += "\n\nThe total value: ";
        msg += "\nDesign: " + value1;
        msg += "\nScientific: " + value2;
        msg += "\nVarieties: " + value3;
    
        return msg;
    }
    

    /**
     * Retrieves the subscribed magazines for a given user.
     *
     * @param optionUser The index of the user.
     * @return A string representation of the subscribed magazines.
     */
    public String showSuscribedMagazines(int optionUser){
        
        return listOfUser.get(optionUser).getSuscribedMagazine();
    }
    /**
     * Cancels the subscription of a magazine for a given user.
     *
     * @param optionUser The index of the user.
     * @param optionMG   The index of the magazine.
     * @return True if the cancellation is successful, false otherwise.
     */
    public boolean cancelSuscription(int optionUser, int optionMG){
        
        if(optionMG>listOfBiblioProducts.size() || optionUser>listOfUser.size()){
            return false;
        }
        BiblioProducts option = listOfBiblioProducts.get(optionMG);

        return listOfUser.get(optionUser).cancelSuscription(option);
    }
    
    /**
     * Retrieves the details of a book.
     *
     * @param bookIndex The index of the book.
     * @return A string representation of the book details.
     */

    public String viewBookDetails(int bookIndex) {
        
        String msg = "";
            
        BiblioProducts book = listOfBiblioProducts.get(bookIndex);
        if (book instanceof Book) {
            Book selectedBook = (Book) book;
            msg += "Book Details:\n";
            msg += "ID: " + selectedBook.getId() + "\n";
            msg += "Name: " + selectedBook.getName() + "\n";
            msg += "Number of Pages: " + selectedBook.getNumberPages() + "\n";
            msg += "Short Review: " + selectedBook.getShortReview() + "\n";
            msg += "Genres: " + selectedBook.getGenre() + "\n";
            msg += "URL: " + selectedBook.getURL() + "\n";
            msg += "Value: " + selectedBook.getValue() + "\n";
            msg += "Number of Sold Books: " + selectedBook.getNumSoldBooks() + "\n";
            msg += "Post Date: " + selectedBook.getPostDateFormated() + "\n";
            msg += "Readed Pages: " + selectedBook.getReadedPages() + "\n";

        }

        return msg;
    }

    /**
     * Retrieves the details of a magazine.
     *
     * @param magazineIndex The index of the magazine.
     * @return A string representation of the magazine details.
     */
    public String viewMagazineDetails(int magazineIndex) {
        
        String msg = "";

        BiblioProducts magazine = listOfBiblioProducts.get(magazineIndex);
        if (magazine instanceof Magazine) {
            Magazine selectedMagazine  = (Magazine) magazine;
            msg += "Book Details:\n";
            msg += "ID: " + selectedMagazine.getId() + "\n";
            msg += "Name: " + selectedMagazine.getName() + "\n";
            msg += "Number of Pages: " + selectedMagazine.getNumberPages() + "\n";
            msg += "Issuance periocity: " + selectedMagazine.getIssPeriod() + "\n";
            msg += "Category: " + selectedMagazine.getCategory() + "\n";
            msg += "URL: " + selectedMagazine.getURL() + "\n";
            msg += "Value: " + selectedMagazine.getValue() + "\n";
            msg += "Number of Active subs: " + selectedMagazine.getActiveSubs() + "\n";
            msg += "Post Date: " + selectedMagazine.getPostDateFormated() + "\n";
            msg += "Readed Pages: " + selectedMagazine.getReadedPages() + "\n";
        }

        return msg;
    }
    /**
     * Retrieves the names of all books in the library.
     *
     * @return A string representation of the book names.
     */
    public String getBHBookInfo(){
        
        String msg = "";   
        for(int i = 0; i< listOfBiblioProducts.size(); i++){

            if(listOfBiblioProducts.get(i) instanceof Book){

                msg += "\n"+(i+1)+". "+listOfBiblioProducts.get(i).getName() +"\n";

            }

        }
        return msg;
    }
    /**
     * Retrieves the names of all magazines in the library.
     *
     * @return A string representation of the magazine names.
     */
    public String getBHMagazineInfo(){
        
        String msg = "";   
        for(int i = 0; i< listOfBiblioProducts.size(); i++){

            if(listOfBiblioProducts.get(i) instanceof Magazine){

                msg += "\n"+(i+1)+". "+listOfBiblioProducts.get(i).getName() +"\n";

            }

        }
        return msg;
    }
    /**
     * Retrieves the names and prices of all books in the library.
     *
     * @return A string representation of the book names and prices.
     */
    public String getBHBookPrice(){
        
        String msg = "";   
        for(int i = 0; i< listOfBiblioProducts.size(); i++){

            if(listOfBiblioProducts.get(i) instanceof Book){

                msg += "\n"+(i+1)+". "+listOfBiblioProducts.get(i).getName()+" - $ " +listOfBiblioProducts.get(i).getValue()+" USD"+"\n";

            }

        }
        return msg;
    }
        /**
     * Retrieves the names and prices of all magazines in the library.
     *
     * @return A string representation of the magazine names and prices.
     */
    public String getBHMagazinePrice(){
        
        String msg = "";   
        for(int i = 0; i< listOfBiblioProducts.size(); i++){

            if(listOfBiblioProducts.get(i) instanceof Magazine){

                msg += "\n"+(i+1)+". "+listOfBiblioProducts.get(i).getName()+" - $ " +listOfBiblioProducts.get(i).getValue()+" USD"+"\n";

            }

        }
        return msg;
    }
    /**
     * Retrieves the names of all standard users in the system.
     *
     * @return A string representation of the standard user names.
     */
    public String getUserStandardInfo(){
        
        String msg = "";   
        for(int i = 0; i< listOfUser.size(); i++){

            if(listOfUser.get(i) instanceof Standard){

                msg += "\n"+(i+1)+". "+listOfUser.get(i).getNameUser() +"\n";

            }

        }
        return msg;
    }
     /**
     * Retrieves the names of all standard premium in the system.
     *
     * @return A string representation of the premium user names.
     */
    public String getUserPremiumInfo(){
        
        String msg = "";   
        for(int i = 0; i< listOfUser.size(); i++){

            if(listOfUser.get(i) instanceof Premium){

                msg += "\n"+(i+1)+". "+listOfUser.get(i).getNameUser() +"\n";

            }

        }
        return msg;
    }
}

package ui;

import java.util.Scanner;


import java.util.Calendar;

import model.Controller;	

/**
 * Class representing the user interface to execute the library program.
 */
public class Executable {

    private Scanner lector;
    private Controller controller;

    /**
     * Constructor for the Executable class.
     */
    public Executable() {
        lector = new Scanner(System.in);
        controller = new Controller();
    }
    public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	/**
	 * Method to display the main menu options to the user and handle their input.
	 */
    public void menu(){
    System.out.println("---------------------------------");
    System.out.println("       Welcome to ReadX       ");
    System.out.println("---------------------------------");
    
    boolean flag = false;

		while (!flag) {

			System.out.println("1. Sign Up");
			System.out.println("2. Manage bibliographic products");
			System.out.println("3. Buy bibliographic products");
			System.out.println("4. Cancel magazine suscription");
			System.out.println("5. Consult product library and read session");
			System.out.println("6. Reports");
			System.out.println("7. Exit");
			int option = lector.nextInt();

			switch (option) {
      
			case 1:
				registerUser();
				break;
			case 2:
				System.out.println("1. Register");
				System.out.println("2. Modify");
				System.out.println("3. Delete");
				int optionBH = lector.nextInt();

				switch(optionBH){
					case 1:
					registerBiblioProducts();
					break;
					case 2:
					System.out.println("Type the option product you want to modify \n1. Book \n2. Magazine");
					int optionMO = lector.nextInt();
						switch(optionMO){
							case 1: 
							modifyBook();
							break;
							case 2:
							modifyMagazine();
							break;
						}
					break;
					case 3:
					System.out.println("Type the option product you want to delete \n1. Book \n2. Magazine");
					int optionDT = lector.nextInt();
						switch(optionDT){
							case 1: 
							deleteBooks();
							break;
							case 2:
							deleteMagazines();
							break;
						}
					break;
				}

			break;
			case 3:
				System.out.println("Type the option product you want to purchase \n1.Book\n2.Magazine");
				int optionPurchase = lector.nextInt();
				switch(optionPurchase){
					case 1: 
					buyBook();
					break;
					case 2:
					buyMagazine();
					break;
				}
				break;
			case 4:
			cancelSub();
			break;
			case 5:
			consultLibrary();
			break;
			case 6:
			System.out.println("1.Acomulate readed pages for type product(Book or Magazine)");
			System.out.println("2.Most read Genre of de book and category of the magazine in the platform");
			System.out.println("3.");
			System.out.println("4.");
			System.out.println("5.");
			int optionRE = lector.nextInt();

			switch(optionRE){
				case 1:
				firstReport();
				break;
				case 2:

				break;
				case 3:

				break;
				case 4:

				break;
				case 5:

				break;
			}
			break;
			case 7:
				flag = true;
				break;
	

			}
		}
	}
	/**
	 * Method to register a new user.
	 */
	private void registerUser(){
		
		lector.nextLine();

		System.out.println("Type the type of user option you want  \n1. Standard \n2. Premium");
		int optionUser = lector.nextInt();
		lector.nextLine();
		System.out.println("Type your full name");
		String nameUser = lector.nextLine();
		System.out.println("Type your document number: ");
		String cc = lector.nextLine();

		Calendar vinculationDate = Calendar.getInstance();
	
		if (controller.registerUser(nameUser,cc,vinculationDate,optionUser)){
			
			System.out.println("The user has been created successfully");

		} else {
			System.out.println("Sorry, the user couldn't be registered");
		}
	}
	/**
	 * Method to register a new bibliographic product (book,magazine).
	 */
	private void registerBiblioProducts() {
		System.out.println("Type the type of bibliographic product option you want to register:\n1. Book\n2. Magazine");
		int optionProducts = lector.nextInt();
		lector.nextLine();
		
		String id = "";
		if(optionProducts==1){
			id = controller.generateHEXAID();
		} else if (optionProducts ==2){
			id = controller.generateALFAID();
		}
	
		System.out.println("Type the product name");
		String name = lector.nextLine();
	
		System.out.println("Type the number of pages");
		int numberPages = lector.nextInt();
	
		System.out.println("----Type the post date----");
		System.out.println("Day: ");
		int dayPostDate = lector.nextInt();
		System.out.println("Month: ");
		int monthPostDate = lector.nextInt();
		System.out.println("Year: ");
		int yearPostDate = lector.nextInt();
	
		String shortReview = "";
		String issPeriod = "";
		int genres = 0;
		int categorys = 0;
		lector.nextLine();
	
		if (optionProducts == 1) {
			System.out.println("Write a short review for the book");
			shortReview = lector.nextLine();
			System.out.println("Type the book genre option:\n1. Science fiction\n2. Fantasy\n3. Historical novel");
			genres = lector.nextInt();
		} else if (optionProducts==2) {
			
			System.out.println("Type the issuance periodicity");
			issPeriod = lector.nextLine();
			System.out.println("Type the magazine category option:\n1. Varieties\n2. Design\n3. Scientist");
			categorys = lector.nextInt();
			
		}
		
		lector.nextLine();

		System.out.println("Type the front page URL");
		String URL = lector.nextLine();
		
		System.out.println("Type the value of the product");
		int value = lector.nextInt();
	
		int numSoldBooks = 0;
		int activeSubs = 0;
		int readedPages = 0;
		if (controller.registerBiblioProducts(name, id, numberPages, shortReview, genres, URL, value, numSoldBooks, optionProducts, yearPostDate, monthPostDate, dayPostDate, readedPages, categorys, issPeriod, activeSubs)) {
			System.out.println("The product has been created successfully");
		} else {
			System.out.println("Sorry, the product couldn't be registered");
		}
	}
	/**
	 * Method to modify a book.
	 */
	private void modifyBook(){
		String query = controller.getBHBookInfo();
		if(query.equals("")){
			System.out.println("No books registered");
		}else{
			
			System.out.println("\nThis is the list of books registered in the system");

			System.out.println(query);
			
			System.out.println("\nSelect the book to edit");
			int option = lector.nextInt();

			lector.nextLine();

			System.out.println("Type the new product ID");
			String newId = lector.nextLine();
		
			System.out.println("Type the new product name");
			String newName = lector.nextLine();
		
			System.out.println("Type the number of pages");
			int newNumberPages = lector.nextInt();
		
			System.out.println("----Type the post date----");
			System.out.println("Day: ");
			int newDayPostDate = lector.nextInt();
			System.out.println("Month: ");
			int newMonthPostDate = lector.nextInt();
			System.out.println("Year: ");
			int newYearPostDate = lector.nextInt();
			
			lector.nextLine();

			System.out.println("Write a short review for the book");
			String newShortReview = lector.nextLine();

			System.out.println("Type the book genre option:\n1. Science fiction\n2. Fantasy\n3. Historical novel");
			int newGenres = lector.nextInt();

			lector.nextLine(); 
			System.out.println("Type the front page URL");
			String newURL = lector.nextLine();
		
			System.out.println("Type the value of the product");
			int newValue = lector.nextInt();
		
			if (controller.modifyBook((option-1),newName, newId, newNumberPages, newShortReview, newGenres, newURL, newValue,newYearPostDate, newMonthPostDate, newDayPostDate)) {
				System.out.println("The book has been modified successfully");
			} else {
				System.out.println("Sorry, the book couldn't be modified");
			}
		
		}

	}
	/**
	 * Method to modify a magazine.
	 */
	private void modifyMagazine(){
		String query = controller.getBHMagazineInfo();
		if(query.equals("")){
			System.out.println("No magazines registered");
		}else{

			System.out.println("\nThis is the list of magazines registered in the system");

			System.out.println(query);
			
			System.out.println("\nSelect the magazine to edit");
			int option = lector.nextInt();
			
			lector.nextLine();

			System.out.println("Type the new product ID");
			String newId = lector.nextLine();
		
			System.out.println("Type the new product name");
			String newName = lector.nextLine();
		
			System.out.println("Type the number of pages");
			int newNumberPages = lector.nextInt();
		
			System.out.println("----Type the post date----");
			System.out.println("Day: ");
			int newDayPostDate = lector.nextInt();
			System.out.println("Month: ");
			int newMonthPostDate = lector.nextInt();
			System.out.println("Year: ");
			int newYearPostDate = lector.nextInt();
		
			System.out.println("Type the magazine category option:\n1. Varieties\n2. Design\n3. Scientist");
			int newCategorys = lector.nextInt();
			lector.nextLine();

			System.out.println("Type the issuance periodicity");
			String newIssPeriod = lector.nextLine();

			System.out.println("Type the front page URL");
			String newURL = lector.nextLine();
		
			System.out.println("Type the value of the product");
			int newValue = lector.nextInt();
		
			if (controller.modifyMagazine((option-1), newName, newId, newNumberPages, newIssPeriod, newCategorys, newURL, newValue,newYearPostDate, newMonthPostDate, newDayPostDate)) {
				System.out.println("The Magazine has been modified successfully");
			} else {
				System.out.println("Sorry, the magazine couldn't be modified");
			}
		}

	}
	/**
	 * Method to delete a book.
	 */
	private void deleteBooks(){

		String query = controller.getBHBookInfo();

		if (query.equals("")) {

			System.out.println("No books registered");
		} else {

			System.out.println("\nThis is the list of books registered in the system");

			System.out.println(query);

			System.out.println("\nSelect the book to delete");

			int bookIndex = lector.nextInt();

			if (controller.deleteBooks((bookIndex-1))) {
				System.out.println("Book deleted successfully");
			} else {
				System.out.println("Sorry, the book couldn't be deleted");
			}

		}
	}
	/**
	 * Method to delete a magazine.
	 */
	private void deleteMagazines(){

		String query = controller.getBHMagazineInfo();

		if (query.equals("")) {

			System.out.println("No magazines registered");
		} else {

			System.out.println("\nThis is the list of magazines registered in the system");

			System.out.println(query);

			System.out.println("\nSelect the magazine to delete");

			int magazineIndex = lector.nextInt();

			if (controller.deleteMagazines((magazineIndex-1))) {
				System.out.println("Magazine deleted successfully");
			} else {
				System.out.println("Sorry, the magazine couldn't be deleted");
			}

		}



	}
	/**
	 * Method to cancel a magazine suscription of a user.
	 */
	private void cancelSub(){
		System.out.println("Type the user that want to cancel a suscription \n1.Standard \n2.Premium");
		int optionUser = lector.nextInt();
		
		String query = controller.getUserStandardInfo();
		String query2 = controller.getUserPremiumInfo();
		
		switch(optionUser){

			case 1: 

			if (query.equals("")) {

				System.out.println("No users registered");
			} else {

				System.out.println("\nThis is the list of standard users registered in the system");

				System.out.println(query);

				System.out.println("\nSelect the user");

				optionUser = lector.nextInt();

			}

			break;

			case 2: 
			if (query2.equals("")) {

				System.out.println("No users registered");
				
			} else {

				System.out.println("\nThis is the list of premium users registered in the system");

				System.out.println(query2);

				System.out.println("\nSelect the user");

				optionUser = lector.nextInt();

			}
			
			break;			
		}
		
		String query3 = controller.showSuscribedMagazines(optionUser-1);
		if(query3.equals("")){
				System.out.println("The user havent suscribe to a magazine");
		}else{
			System.out.println(query3);
			System.out.println("Select the magazine");
			int optionMG = lector.nextInt();
			if(controller.cancelSuscription(optionUser-1, optionMG-1)){
				System.out.println("Unsubscribed successfully");
			} else {
				System.out.println("The operation could not be performed");
			}
		}
	}
	/**
	 * Method to buy a book.
	 */
	public void buyBook(){
	
		System.out.println("Type the user that want to buy a book \n1.Standard \n2.Premium");
		int optionUser = lector.nextInt();
		
		String query = controller.getUserStandardInfo();
		String query2 = controller.getUserPremiumInfo();
		
		switch(optionUser){

			case 1: 

			if (query.equals("")) {

				System.out.println("No users registered");
			} else {

				System.out.println("\nThis is the list of standard users registered in the system");

				System.out.println(query);

				System.out.println("\nSelect the user");

				optionUser = lector.nextInt();

			}

			break;

			case 2: 
			if (query2.equals("")) {

				System.out.println("No users registered");
			} else {

				System.out.println("\nThis is the list of premium users registered in the system");

				System.out.println(query2);

				System.out.println("\nSelect the user");

				optionUser = lector.nextInt();

			}
			
			break;
		}

		String query3 = controller.getBHBookPrice();

		if (query3.equals("")) {

			System.out.println("No books registered");
		} else {

			System.out.println("\nThis is the list of books registered in the system");

			System.out.println(query3);

			System.out.println("\nSelect the book");

			int optionBUY = lector.nextInt();
			
			if(controller.buyBook((optionBUY-1),(optionUser-1))){
				System.out.println("-------The book has been purchased successfully-------");
			} else {
				System.out.println("Sorry, the product cant be obtained");
			}

		}

	}

	/**
	 * Method to buy a magazine.
	 */
	public void buyMagazine(){
		String query = controller.getUserStandardInfo();
		String query2 = controller.getUserPremiumInfo();
		System.out.println("Type the user that want to suscribe a magazine \n1.Standard \n2.Premium");
		int optionUser = lector.nextInt();

		switch(optionUser){

			case 1: 

			if (query.equals("")) {

				System.out.println("No users registered");
			} else {

				System.out.println("\nThis is the list of standard users registered in the system");

				System.out.println(query);

				System.out.println("\nSelect the user");

				optionUser = lector.nextInt();

			}

			break;

			case 2: 
			if (query2.equals("")) {

				System.out.println("No users registered");
			} else {

				System.out.println("\nThis is the list of premium users registered in the system");

				System.out.println(query2);

				System.out.println("\nSelect the user");

				optionUser = lector.nextInt();

			}
			
			break;
		}

		String query3 = controller.getBHMagazinePrice();

		if (query3.equals("")) {

			System.out.println("No magazines registered");
		} else {

			System.out.println("\nThis is the list of magazines registered in the system");

			System.out.println(query3);

			System.out.println("\nSelect the magazine");

			int optionBUY = lector.nextInt();
			
			if(controller.buyMagazine((optionBUY-1),(optionUser-1))){
				System.out.println("------You have subscribed to the magazine successfully------");
			} else {
				System.out.println("Sorry, the product cant be obtained");
			}

		}

	}

	/**
	 * Method to consult a library of a user and start a reading session.
	 */
	public void consultLibrary() {
		String query = controller.getUserStandardInfo();
		String query2 = controller.getUserPremiumInfo();
		boolean cond = true;
		boolean cond1 = true;
	
		System.out.println("Type the user option that want to consult the library\n1.Standard \n2.Premium");
		int optionUser = lector.nextInt();
	
		switch (optionUser) {
	
			case 1:
	
				if (query.equals("")) {
					System.out.println("No users registered");
				} else {
					System.out.println("\nThis is the list of standard users registered in the system");
					System.out.println(query);
					System.out.println("\nSelect the user");
					optionUser = lector.nextInt();
				}
	
				break;
	
			case 2:
				if (query2.equals("")) {
					System.out.println("No users registered");
				} else {
					System.out.println("\nThis is the list of premium users registered in the system");
					System.out.println(query2);
					System.out.println("\nSelect the user");
					optionUser = lector.nextInt();
				}
				break;
		}
		while (cond) {
			int cont = 0;
			int currentPage = 1;
			String option = "";
			String query3 = controller.consultLibrary(optionUser - 1);
			if (query3.equals("")) {
				System.out.println("The user hasn't purchased bibliographic products");
			} else {
				System.out.println(query3);
			}
	
			System.out.println("Enter the product code to start the reading simulation or type E for exit");
	
			lector.nextLine();
	
			String decisionUser = lector.nextLine();
			if (decisionUser.equalsIgnoreCase("E")) {
				break;
			}
			int numberPages = controller.getNumberOfPages(decisionUser);
			while (cond1) {
				currentPage = controller.updateCurrentPage(option, currentPage, numberPages);
				System.out.println(controller.readingSession(decisionUser, optionUser, option, currentPage, cont));
				option = lector.nextLine();
			}
		}
	}
	
	public void firstReport(){
		System.out.println(controller.firstReport());
	}



}



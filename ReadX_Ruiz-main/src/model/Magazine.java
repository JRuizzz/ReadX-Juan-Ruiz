package model;

import java.util.Calendar;

/**
 * The Magazine class represents a magazine in the library system.
 */
public class Magazine extends BiblioProducts {

    private Category category;
    private String issPeriod;
    private int activeSubs;

    /**
     * Constructs a new Magazine object with the specified properties.
     *
     * @param name         the name of the magazine
     * @param id           the ID of the magazine
     * @param numberPages  the number of pages in the magazine
     * @param postDate     the post date of the magazine
     * @param value        the value of the magazine
     * @param URL          the URL of the magazine
     * @param readedPages  the number of read pages in the magazine
     * @param category     the category of the magazine
     * @param issPeriod    the issuance period of the magazine
     * @param activeSubs   the number of active subscriptions for the magazine
     */
    public Magazine(String name, String id, int numberPages, Calendar postDate, int value, String URL, int readedPages, Category category, String issPeriod, int activeSubs) {
        super(name, id, numberPages, postDate, value, readedPages, URL);
        this.category = category;
        this.issPeriod = issPeriod;
        this.activeSubs = activeSubs;
    }

    /**
     * Constructs a new Magazine object by copying another Magazine object.
     *
     * @param magazineToCopy the magazine to copy
     */
    public Magazine(Magazine magazineToCopy) {
        super(magazineToCopy.getName(), magazineToCopy.getId(), magazineToCopy.getNumberPages(), magazineToCopy.getPostDate(), magazineToCopy.getValue(), magazineToCopy.getReadedPages(), magazineToCopy.getURL());
        this.category = magazineToCopy.getCategory();
        this.issPeriod = magazineToCopy.getIssPeriod();
        this.activeSubs = magazineToCopy.getActiveSubs();
    }

    /**
     * Returns the category of the magazine.
     *
     * @return the category of the magazine
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the magazine.
     *
     * @param category the category of the magazine
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns the issuance period of the magazine.
     *
     * @return the issuance period of the magazine
     */
    public String getIssPeriod() {
        return issPeriod;
    }

    /**
     * Sets the issuance period of the magazine.
     *
     * @param issPeriod the issuance period of the magazine
     */
    public void setIssPeriod(String issPeriod) {
        this.issPeriod = issPeriod;
    }

    /**
     * Returns the number of active subscriptions for the magazine.
     *
     * @return the number of active subscriptions for the magazine
     */
    public int getActiveSubs() {
        return activeSubs;
    }

    /**
     * Sets the number of active subscriptions for the magazine.
     *
     * @param activeSubs the number of active subscriptions for the magazine
     */
    public void setActiveSubs(int activeSubs) {
        this.activeSubs = activeSubs;
    }
}

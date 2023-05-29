package model;

import java.util.Calendar;

/**
 * The Invoice class represents an invoice for a purchased product.
 */
public class Invoice {
    private Calendar operationDate;
    private double amount;
    private String nameProduct;

    /**
     * Constructs a new Invoice object with the specified product name, operation date, and amount.
     *
     * @param nameProduct   the name of the product associated with the invoice
     * @param operationDate the date of the invoice operation
     * @param amount        the amount of the invoice
     */
    public Invoice(String nameProduct, Calendar operationDate, double amount) {
        this.operationDate = Calendar.getInstance();
        this.amount = amount;
        this.nameProduct = nameProduct;
    }

    /**
     * Returns the operation date of the invoice.
     *
     * @return the operation date of the invoice
     */
    public Calendar getOperationDate() {
        return operationDate;
    }

    /**
     * Sets the operation date of the invoice.
     *
     * @param operationDate the operation date of the invoice
     */
    public void setOperationDate(Calendar operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * Returns the amount of the invoice.
     *
     * @return the amount of the invoice
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the invoice.
     *
     * @param amount the amount of the invoice
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the name of the product associated with the invoice.
     *
     * @return the name of the product associated with the invoice
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * Sets the name of the product associated with the invoice.
     *
     * @param nameProduct the name of the product associated with the invoice
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}

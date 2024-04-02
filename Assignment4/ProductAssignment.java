/**
 * Author: Kartik Pandit
 * 100935721
 * Description: This code creates a Java software that models and shows product information, including perishable goods with expiration dates.   
 */ 

package Assignment4;

import java.util.Date;

class ProductAssignment {
    private int productCode;
    private String productName;
    private double unitPrice;
    private int quantityInStock;
    private int quantityRequired;
    private String instructions;

    // Default constructor
    public ProductAssignment() {
        this.productCode = 0;
        this.productName = "Unnamed Product";
        this.unitPrice = 0.0;
        this.quantityInStock = 0;
        this.quantityRequired = 0;
        this.instructions = "";
    }

    // Parameterized constructor
    public ProductAssignment(int productCode, String productName, double unitPrice, int quantityInStock, int quantityRequired, String instructions) {
        this.productCode = productCode;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.quantityRequired = quantityRequired;
        this.instructions = instructions;
    }

    // Getter and setter methods
    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(int quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // Display function
    public void showDetails() {
        System.out.println("Product Code: " + productCode);
        System.out.println("Product Name: " + productName);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.println("Quantity Required: " + quantityRequired);
        System.out.println("Instructions: " + instructions);
    }
}

// PerishableProduct class
class PerishableProductAssignment extends ProductAssignment {
    private Date expiryDate;

    // Overloaded constructor
    public PerishableProductAssignment(int productCode, String productName, double unitPrice, int quantityInStock, int quantityRequired, String instructions, Date expiryDate) {
        super(productCode, productName, unitPrice, quantityInStock, quantityRequired, instructions);
        this.expiryDate = expiryDate;
    }

    // Getter and setter for expiry date
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Display function overriding the base class display function
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Expiry Date: " + expiryDate);
    }
}
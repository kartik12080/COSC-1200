/**
 * Author: Kartik Pandit
 * 100935721
 * Description: This code creates a Java software that models and shows product information, including perishable goods with expiration dates.   
 */ 

package Assignment4;

import java.sql.Date;

// Driver class
public class Main {
    public static void main(String[] args) {
        // Creating multiple products
        ProductAssignment product1 = new ProductAssignment(111, "Shirt", 50.50, 50, 10, "Most Comfortable");
        ProductAssignment product2 = new ProductAssignment(122, "Shoes", 70.25, 30, 5, "Waterproof");
        ProductAssignment product3 = new ProductAssignment(133, "Jeans", 90.75, 40, 8, "Machine washable");

        // Creating multiple perishable products
        @SuppressWarnings("deprecation")
        PerishableProductAssignment perishableProduct1 = new PerishableProductAssignment(144, "Milk", 20.50, 20, 15, "Keep  it refrigerated", new Date(2024, 4, 30));
        @SuppressWarnings("deprecation")
        PerishableProductAssignment perishableProduct2 = new PerishableProductAssignment(155, "Bread", 12.75, 15, 10, "Keep away from moisture", new Date(2025, 5, 29));

        // Putting all products in an array
        ProductAssignment[] products = {product1, product2, product3, perishableProduct1, perishableProduct2};

        // Displaying details of all products
        for (ProductAssignment product : products) {
            product.showDetails();
            System.out.println();
        }
    }
}
/**
 * Author: Kartik Pandit
 * Program Name: Vaccine Management System of COVID19
 * Description: This Java console program shows recorded data and maintains COVID19 variant JN.1 vaccine records. I use the professor's assistance with organization.   
 */ 


package Assiignment3;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) throws ParseException {
        // Create an empty Vaccine using the default constructor
        Vaccine emptyVaccine = new Vaccine();

        // Display the values of the empty Vaccine in a non-linear format
        emptyVaccine.display(false);

        // Use setters to add values to the empty Vaccine
        emptyVaccine.setId(1);
        emptyVaccine.setName("COVID-19 VAX ");    
        emptyVaccine.setCost(40.0);
        emptyVaccine.setQuantity(10000);
        emptyVaccine.setExpiryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2028-11-12"));
        emptyVaccine.setSpecialInstructions("Store in a place which is cool");

        // Display the values of the Vaccine in a non-linear format
        emptyVaccine.display(false);

        // Use parameterized constructor to create two more vaccines
        Vaccine vaccine1 = new Vaccine(2, "Vaccine X   ", 40.0, 500, new SimpleDateFormat("yyyy-MM-dd").parse("2025-01-01"), "Use caution when handling");
        Vaccine vaccine2 = new Vaccine(3, "Vaccine Y   ", 35.5, 750, new SimpleDateFormat("yyyy-MM-dd").parse("2025-01-01"), "Maintain refrigeration");

        // Create an array to save all the vaccines
        Vaccine[] vaccines = {emptyVaccine, vaccine1, vaccine2};

        // Use the array to display the contents of the Vaccines in a table format
        System.out.printf("%-5s%-20s%-10s%-5s%-15s%-30s%n",
                "SKU", "Vaccine Name  ", "Unit Cost", "QTY", "Expiry", "Special Instructions");
        System.out.println("-----------------------------------------------------------------");
        for (Vaccine vaccine : vaccines) {
            vaccine.display(true);
        }
    }
}
/**
 * Author: Kartik Pandit
 * Program Name: Vaccine Management System of COVID19
 * Description: This Java console program shows recorded data and maintains COVID19 variant JN.1 vaccine records. I use the professor's assistance with organization.   
 */ 
 
 package Assiignment3;

            import java.text.SimpleDateFormat;
  
            import java.util.Date;
            
            class Vaccine {
                private int id;
                private String name;
                private double cost;
                private int quantity;
                private Date expiryDate;
                private String specialInstructions;
            
                // Default constructor
                public Vaccine() {
                    // Setting the meaningful default values
                    this.id = 0;
                    this.name = "Unknown Vaccine";
                    this.cost = 0.0;
                    this.quantity = 0;
                    this.expiryDate = new Date();
                    this.specialInstructions = "Use caution when handling";
                }
            
                //  constructing the Parameters
                public Vaccine(int id, String name, double cost, int quantity, Date expiryDate, String specialInstructions) {
                    this.id = id;
                    this.name = name;
                    this.cost = cost;
                    this.quantity = quantity;
                    this.expiryDate = expiryDate;
                    this.specialInstructions = specialInstructions;
                }
            
                // Accessor methods
                public int getId() {
                    return id;
                }
            
                public String getName() {
                    return name;
                }
            
                public double getCost() {
                    return cost;
                }
            
                public int getQuantity() {
                    return quantity;
                }
            
                public Date getExpiryDate() {
                    return expiryDate;
                }
            
                public String getSpecialInstructions() {
                    return specialInstructions;
                }
            
                // Mutator methods
                public void setId(int id) {
                    this.id = id;
                }
            
                public void setName(String name) {
                    this.name = name;
                }
             
                public void setCost(double cost) {
                    this.cost = cost;
                }
            
                public void setQuantity(int quantity) {
                    this.quantity = quantity;
                }
            
                public void setExpiryDate(Date expiryDate) {
                    this.expiryDate = expiryDate;
                }
            
                public void setSpecialInstructions(String specialInstructions) {
                    this.specialInstructions = specialInstructions;
                }
            
                // Display method
                public void display(boolean inTableFormat) {
                    if (inTableFormat) {
                        // Display in table format
                        System.out.printf("%-5d%-20s%-10.2f%-5d%-15s%-30s%n",
                                id, name, cost, quantity, new SimpleDateFormat("yyyy-MM-dd").format(expiryDate), specialInstructions);
                    } else {
                        // Display in non-linear format
                        System.out.println("SKU: " + getId());
                        System.out.println("Name of the Vaccine : " + getName());
                        System.out.println("Unit Cost: " + getCost());
                        System.out.println("Quantity on hand: " + getQuantity());
                        System.out.println("Date of expiry: " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate));
                        System.out.println("Instructions: " + specialInstructions);
                    }
                }
            }
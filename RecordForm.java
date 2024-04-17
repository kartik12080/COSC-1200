/**
 * Authors: Katik Pandit(100935721), Kavya Ganatra(100934387)
 * Group 10
 * Project: User Interface & Files
 * Description: This Java Swing application creates a form for registering new patient records and saves the information to a file.
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.BufferedWriter;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 
 // Main class for the record form
 public class RecordForm extends JFrame {
     // Components declaration
     private JTextField nameTextField, ownerTextField, emailTextField, dateTextField, addressTextField;
     private JLabel titleLabel, nameLabel, ownerLabel, emailLabel, vetLabel, labelDate, addressLabel, messageLabel;
     private JRadioButton vet1Button, vet2Button;
     private ButtonGroup vetGroup;
     private JButton registerButton, clearButton, exitButton;
 
     // Constructor
     public RecordForm() {
         // JFrame settings
         setTitle("New Patient Record");
         setIconImage(new ImageIcon("/FormImage.png").getImage());
         setLayout(new GridLayout(0, 2, 5, 5)); // 0 rows, 2 columns, with 5px horizontal and vertical gaps
 
         // Initialize components
         initializeComponents();
 
         // Add components to the frame
         addComponentsToFrame();
 
         // JFrame settings continued
         setPreferredSize(new Dimension(500, 350));
         setMaximumSize(new Dimension(500, 350)); // Set maximum size to prevent maximizing
         pack();
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }
 
     // Initialize GUI components
     private void initializeComponents() {
         // Initializing labels
         titleLabel = new JLabel("New Patient Record");
         nameLabel = new JLabel("Patient Name:");
         ownerLabel = new JLabel("Owner:");
         emailLabel = new JLabel("Email Address:");
         vetLabel = new JLabel("Vet Assigned:");
         labelDate = new JLabel("Date:");
         addressLabel = new JLabel("Address:");
         messageLabel = new JLabel("");
 
         // Initializing text fields
         nameTextField = new JTextField(20);
         ownerTextField = new JTextField(20);
         emailTextField = new JTextField(20);
         dateTextField = new JTextField(20);
         addressTextField = new JTextField(20);
 
         // Initializing radio buttons and button group
         vet1Button = new JRadioButton("Vet 1");
         vet2Button = new JRadioButton("Vet 2");
         vet1Button.setSelected(true);
         vetGroup = new ButtonGroup();
         vetGroup.add(vet1Button);
         vetGroup.add(vet2Button);
 
         // Initializing buttons and adding action listeners
         registerButton = new JButton("Register");
         clearButton = new JButton("Clear");
         exitButton = new JButton("Exit");
 
         registerButton.addActionListener(e -> registerPatient());
         clearButton.addActionListener(e -> clearForm());
         exitButton.addActionListener(e -> System.exit(0));
     }
 
     // Add components to the frame
     private void addComponentsToFrame() {
         add(titleLabel);
         add(new JLabel()); // Spacer
         add(nameLabel);
         add(nameTextField);
         add(ownerLabel);
         add(ownerTextField);
         add(emailLabel);
         add(emailTextField);
         add(vetLabel);
         add(vet1Button);
         add(new JLabel()); // Spacer
         add(vet2Button);
         add(labelDate);
         add(dateTextField);
         add(addressLabel);
         add(addressTextField);
         add(registerButton);
         add(clearButton);
         add(exitButton);
         add(messageLabel);
     }
 
     // Register button action
     private void registerPatient() {
         if (validateInput()) {
             writeToFile();
         }
     }
 
     // Validate input fields
     private boolean validateInput() {
         if (nameTextField.getText().isEmpty() || ownerTextField.getText().isEmpty() || emailTextField.getText().isEmpty()) {
             showMessage("Error: Please fill in all required fields.");
             return false;
         } else if (nameTextField.getText().matches(".\\d+.")) { // Check if name contains digits
             showMessage("Error: Name cannot contain numbers.");
             return false;
         } else if (!emailTextField.getText().contains("@")) { // Check if email contains @
             showMessage("Error: Invalid email address.");
             return false;
         }
         return true;
     }
 
     // Write patient information to file
     private void writeToFile() {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("newpatientfile.txt"))) {
             writer.write("*Patient Registration Document*\n");
             writer.write("Patient Name: " + nameTextField.getText() + "\n");
             writer.write("Owner: " + ownerTextField.getText() + "\n");
             writer.write("Email Address: " + emailTextField.getText() + "\n");
             writer.write("Address: " + addressTextField.getText() + "\n");
             writer.write("Vet Assigned: " + (vet1Button.isSelected() ? "Vet 1" : "Vet 2") + "\n");
             writer.write("Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\n");
             showMessage("Write successful");
         } catch (IOException e) {
             showMessage("Error: Write unsuccessful");
         }
     }
 
     // Clear form fields
     private void clearForm() {
         showMessage("");
         nameTextField.setText("");
         ownerTextField.setText("");
         emailTextField.setText("");
         addressTextField.setText("");
         vet1Button.setSelected(true);
         dateTextField.setText("");
         nameTextField.requestFocusInWindow();
     }
 
     // Display message in message label
     private void showMessage(String message) {
         messageLabel.setText(message);
     }
 
     // Main method
     public static void main(String[] args) {
         SwingUtilities.invokeLater(RecordForm::new);
     }
 }
 
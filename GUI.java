// These are all my imports I have imported java swing, awt, ActionEvent, ActionListener, LinkedList, Objects //

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;


// This is my GUI class that extends JFrame and implements ActionListener //
public class GUI extends JFrame implements ActionListener {

    long sbAllData;

    // This is a JButton called button //
    JButton button;
    JButton button2;

    // These are my text-fields //
    JTextField textField;
    JTextField textField2;
    JTextField textField3;

    // This is my checkbox //
    JCheckBox checkbox;


    // Linked List for the people who already have accounts in the bank //
    LinkedList<Account> accounts = new LinkedList<>();

    Account foundAccount = null;

    // These are the main account holders right now, I have also included some of my friends' names for fun //

    /***
     Hiran    Patel     11        10000
     Jeffrey   Ting      22        10
     Paul      Wilson    33        50000
     Adam      Worrallo  44        99999
     ***/
    public GUI() {

        // The account holders right now are added to the linked list //
        // In the future, I will create a database that can hold countless information on account holders //

        accounts.add(new Account("Hiran", "Patel", 10000, 11));
        accounts.add(new Account("Jeffery", "Ting", 10, 22));
        accounts.add(new Account("Paul", "Wilson", 50000, 33));
        accounts.add(new Account("Adam", "Worrallo", 99999, 44));
        accounts.add(new Account("Ronak", "Basnet", 10000, 55));
        accounts.add(new Account("Subol", "Bikram Kuwar", 99999, 66));
        accounts.add(new Account("Binayak", "Chhetri", 99999, 77));

        // This is the title of my bank //
        this.setTitle("SBK Banking System");
        // I have set the login page to exit on close //
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting resizable to false so that the user can't extend or stretch the interface //
        this.setResizable(false);
        // The maximum side is 800, 800 of the login page //
        this.setSize(800, 800);

        //Calling the in-built java methods set background color of the content pane I made it white-gray color //
        this.getContentPane().setBackground(new Color(0x0e9e6dd));

        // Making a header panel with BorderLayout //
        JPanel headerPanel = new JPanel(new BorderLayout());
        // Without this, nothing would load, so you have to set it false to make it transparent //
        headerPanel.setOpaque(false);
        // Set background color of a header panel //
        headerPanel.setBackground(new Color(0x093A3E));

        // The Intro title to my bank //
        JLabel label = new JLabel("Welcome to the Bank of SBK", JLabel.CENTER);
        // Setting the text to red //
        label.setForeground(new Color(0x0dc0f0a));
        // Making the font italic and Serif //
        label.setFont(new Font("Serif", Font.ITALIC, 55));
        // You have to make this visible //
        label.setVisible(true);

        // Form panel with GridBagLayout //
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        // Set background color of a form panel //
        formPanel.setBackground(new Color(0x093A3E));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);


        // Create and style the "First Name" label
        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setForeground(new Color(0x0dc0f0a));
        firstNameLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        // Add the "First Name" label and text field to the formPanel
        formPanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        textField = new JTextField(20);
        textField.setFont(new Font("Serif", Font.ITALIC, 20));
        textField.setText("");
        formPanel.add(textField, gbc);

        // Create and style the "Last Name" label
        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setForeground(new Color(0x0dc0f0a));
        lastNameLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        // Add the "Last Name" label and text field to the formPanel
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        textField2 = new JTextField(20);
        textField2.setFont(new Font("Serif", Font.ITALIC, 20));
        formPanel.add(textField2, gbc);

        // Create and style the "Account Number" label
        JLabel accountNumberLabel = new JLabel("Account Number: ");
        accountNumberLabel.setForeground(new Color(0x0dc0f0a));
        accountNumberLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));

        // Add the "Account Number" label and text field to the formPanel
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(accountNumberLabel, gbc);
        gbc.gridx = 1;
        textField3 = new JTextField(20);
        textField3.setFont(new Font("Serif", Font.ITALIC, 20));
        formPanel.add(textField3, gbc);


        // JCheckbox "I am not a robot"
        checkbox = new JCheckBox("I am not a robot");
        checkbox.setOpaque(false); // Set the background transparent to match the form panel
        checkbox.setForeground(new Color(0x0dc0f0a)); // Set the checkbox text color
        checkbox.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        checkbox.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = -5; // Adjust the gridy value to position it
        gbc.gridwidth = 6; // Span across two columns
        formPanel.add(checkbox, gbc);


        // Create and style the "Login" button
        button = new JButton("Login");
        button.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        button.setForeground(new Color(0x0dc0f0a));
        button.setBackground(Color.white);
        button.setFocusable(false);
        button.addActionListener(this);

        // Add the "Login" button below the "Account Number" field
        gbc.gridx = 1;
        gbc.gridy = 3; // Move to the next row
        gbc.gridwidth = 4; // Span across both columns
        formPanel.add(button, gbc);

        // Add components to the header panel
        headerPanel.add(label, BorderLayout.NORTH);
        headerPanel.add(formPanel, BorderLayout.CENTER);

        // Add a header panel to the content pane
        this.getContentPane().add(headerPanel, BorderLayout.CENTER);

        // Set the icon image
        ImageIcon SBK = new ImageIcon(Objects.requireNonNull(getClass().getResource("/SBK.png")));
        if (SBK.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Error loading image: SBK.png");
        } else {
            this.setIconImage(SBK.getImage());
        }

        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent login) {

        // Making a variable so that I can manipulate the text-field //

        //Trimming the user input so that I don't get any simple mistakes //

        String typedFirstName = textField.getText().trim();
        String typedLastName = textField2.getText().trim();
        String accountNumText = textField3.getText().trim();

        // Make an account found true at first so that when the real names are found, we can make it true //
        boolean accountFound = false;

        // Check if the account number is a valid number and if it is a string or a character of some sort give then JOption pane //
        // this happened while I was checking testcases that's why I needed an exception//

        int enteredAccountNum = 0;
        try {

            // This is an attempt to convert the text to an integer so that it can access the account if it doesn't then JOption pane //
            enteredAccountNum = Integer.parseInt(accountNumText);
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please enter a valid account number.");
            return; // Exit the method if the account number is invalid
        }

        // Check if credentials match any account in the list //
        // This is a linked list so remember the account holders are in the account linked list //

        // Loop through the accounts so that this system finds its account holder and gives them access //
        for (Account account : accounts) {
            if (account.getFirstName().equalsIgnoreCase(typedFirstName) &&
                    account.getLastName().equalsIgnoreCase(typedLastName) &&
                    account.getAccountNum() == enteredAccountNum) {
                accountFound = true;
                foundAccount = account;
                break;
            }
        }

        if (accountFound && checkbox.isSelected()) {
            this.dispose();
            new NewScreen(foundAccount);// Pass the found account to the Balance screen
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials or checkbox not selected! Please try again.");

        }
    }


}


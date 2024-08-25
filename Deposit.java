import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;

public class Deposit extends JFrame implements ActionListener {


    JTextField textField;
    JLabel label;
    JButton button;

    JLabel label2;

    JLabel label3;

    Account account;


    Deposit(Account account) {

        this.account = account;

        NumberFormat formatNum = NumberFormat.getNumberInstance();
        String formatBalance = formatNum.format(account.getBalance());

        label = new JLabel("Enter amount: ", JLabel.CENTER);
        label.setForeground(new Color(0x0ffff00));
        label.setFont(new Font("Serif", Font.ITALIC , 30));
        label.setBounds(200, 120, 300, 50);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 800);

        // Add the label to the layered pane
        layeredPane.add(label, Integer.valueOf(2));

        ImageIcon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/ATM.png")));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);

        // Retrieve the JLayeredPane with the background image
        JLayeredPane backgroundLayeredPane = getLayeredPaneWithBackground(backgroundImg);

        // Set the content pane to the layered pane with a background //

        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(50, 20));
        textField.setForeground(new Color(0x0ffff00));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC,20));
        textField.setBounds(450, 135, 100, 30);
        layeredPane.add(textField, Integer.valueOf(2));

        button = new JButton("Deposit");
        button.setBounds(360, 195, 100, 40);
        button.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        button.setForeground(new Color(0x0));
        button.setBackground(Color.yellow);
        button.setFocusable(false);
        button.addActionListener(this);
        layeredPane.add(button, Integer.valueOf(2));

        label2 = new JLabel("Your balance is $" + formatBalance, JLabel.CENTER);
        label2.setForeground(new Color(0x0ffff00));
        label2.setFont(new Font("Serif", Font.ITALIC , 30));
        label2.setBounds(5, 140, 800, 300);

       // label3 = new JLabel("Your balance is $" + formatBalance, JLabel.CENTER);
        label3 = new JLabel("", JLabel.CENTER);
        label3.setForeground(new Color(0x0ffff00));
        label3.setFont(new Font("Serif", Font.ITALIC, 30));
        label3.setBounds(5, 180, 800, 300);
        layeredPane.add(label3, Integer.valueOf(2));

        // Add the label to the layered pane
        layeredPane.add(label2, Integer.valueOf(2));

        this.setContentPane(backgroundLayeredPane);

        this.add(button);
        this.add(textField);
        // Add the label to the main frame
        this.add(label);
        this.add(label2);
        this.add(label3);

        this.setSize(800, 800);
        this.setVisible(true);
    }

    private static JLayeredPane getLayeredPaneWithBackground(Image backgroundImg) {
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImg);

        // Create a JLabel with the background image
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 800);

        // Create a layered pane to manage layering
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(100, 100, 100, 80);

        // Add background first, then thought bubble, then components
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        return layeredPane;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button){
            try{
                int depositAmount = Integer.parseInt(textField.getText());

                // This goes back to the account class and adds them //
                account.deposit(depositAmount);

                NumberFormat formatNum = NumberFormat.getNumberInstance();
                String formatBalance = formatNum.format(account.getBalance());


                label2.setText("Your balance is now: ");
                label3.setText("$" + formatBalance);




            }catch(NumberFormatException exception){  // JOption Pane for if people write Strings and chars instead of int //
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }
}





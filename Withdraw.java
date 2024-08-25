import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;

public class Withdraw extends JFrame implements ActionListener {
    JLabel label;

    JTextField textField;

    JButton button;

    Account account;
    Withdraw(Account account){

        this.account = account;

        NumberFormat formatNum = NumberFormat.getNumberInstance();
        String formatBalance = formatNum.format(account.getBalance());

        ImageIcon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/ATM2.png")));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImg);

        // Create a JLabel with the background image
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 800);

        // Create a layered pane to manage layering
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 800);


        // Add background first, then thought bubble, then components
        layeredPane.add(backgroundLabel, Integer.valueOf(0));


        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(50, 20));
        textField.setForeground(new Color(0x032cd32));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC,20));
        textField.setBounds(180, 200, 250, 30);
        layeredPane.add(textField, Integer.valueOf(2));

        button = new JButton("Withdraw");
        button.setBounds(235, 250, 150, 40);
        button.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        button.setForeground(new Color(0x0));
        button.setBackground(Color.white);
        button.setFocusable(false);
        button.addActionListener(this);
        layeredPane.add(button, Integer.valueOf(2));

        label = new JLabel("Your balance is $" + formatBalance, JLabel.CENTER);
        label.setForeground(new Color(0x0));
        label.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 26));
        label.setBounds(-100, 180, 800, 300);

        layeredPane.add(label, Integer.valueOf(2));

        this.add(label);


        this.add(button);
        this.add(textField);
        this.setResizable(false);
        this.add(backgroundLabel);


        this.setSize(800, 800);
        this.setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button){

            try{
                int depositAmount = Integer.parseInt(textField.getText());

                // This goes back to the account class and adds them //
                account.withdraw(depositAmount);

                NumberFormat formatNum = NumberFormat.getNumberInstance();
                String formatBalance = formatNum.format(account.getBalance());

                if(account.getBalance() < 0){
                    label.setText("You have no money!!");
                }else{
                    label.setText("Your balance is now: " + formatBalance) ;
                }



            }catch(NumberFormatException exception){  // JOption Pane for if people write Strings and chars instead of int //
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}

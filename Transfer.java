import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Transfer extends JFrame implements ActionListener {

    JLabel label;
    JTextField textField;
    JButton button;

    // Instance variables for the accounts //
    Account sbkAccount;
    Account hiranAccount;

    // Constructor where the accounts are passed //
    Transfer(Account sbkAccount, Account hiranAccount) {
        this.sbkAccount = sbkAccount;
        this.hiranAccount = hiranAccount;

        // Basic gui components //

        ImageIcon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/ATM3.png")));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImg);

        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 800);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 800);

        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(50, 20));
        textField.setForeground(new Color(0x032cd32));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 20));
        textField.setBounds(280, 200, 250, 30);
        layeredPane.add(textField, Integer.valueOf(2));

        button = new JButton("Transfer");
        button.setBounds(330, 250, 150, 40);
        button.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        button.setForeground(new Color(0x0));
        button.setBackground(Color.white);
        button.setFocusable(false);
        button.addActionListener(this);
        layeredPane.add(button, Integer.valueOf(2));

        NumberFormat formatNum = NumberFormat.getNumberInstance();
        String formatBalance = formatNum.format(sbkAccount.getBalance());

        label = new JLabel("Your balance is $" + formatBalance, JLabel.CENTER);
        label.setForeground(new Color(0x0));
        label.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 26));
        label.setBounds(10, 180, 800, 300);

        layeredPane.add(label, Integer.valueOf(2));

        this.add(layeredPane);

        this.setSize(800, 800);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                // pass the text-field to int //
                int transferAmount = Integer.parseInt(textField.getText());

                // Transferring part was really confusing in GUI, so I just have a transfer button, but it does nothing, it just gives JOptionpane message //
                if (transferAmount > sbkAccount.getBalance()) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds in SBK's account!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Transfer logic: Withdraw from SBK's account and deposit into Hiran's account //
                sbkAccount.withdraw(transferAmount);
                hiranAccount.deposit(transferAmount);

                // Update the balance label after the transfer and maybe hope for the best //
                NumberFormat formatNum = NumberFormat.getNumberInstance();
                String formatBalance = formatNum.format(sbkAccount.getBalance());


                // Just a JOptionPane for Transfer success //
                label.setText("Your balance is now: $" + formatBalance);
                JOptionPane.showMessageDialog(this, "Transfer successful!");

                // if you try to give someone money, you don't have this JOptionpane will do the job //
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }}
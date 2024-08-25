import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class NewScreen extends JFrame implements ActionListener {

    Account account;
    JLabel label, label2, label3;
    JButton button, button2, button3, button4;

    NewScreen(Account account) {

        this.account = account;
//        // Initialize the label
        label = new JLabel("Please choose the options", JLabel.LEFT);
        label.setForeground(new Color(0x0dc0f0a));
        label.setFont(new Font("Serif", Font.ITALIC, 20));
        label.setBounds(26, 110, 400, 30);

        label2 = new JLabel("Hi, My name is Amy", JLabel.LEFT);
        label2.setForeground(new Color(0x0dc0f0a));
        label2.setFont(new Font("Serif", Font.ITALIC, 20));
        label2.setBounds(45, 80, 400, 30);

        label3 = new JLabel("to your right", JLabel.LEFT);
        label3.setForeground(new Color(0x0dc0f0a));
        label3.setFont(new Font("Serif", Font.ITALIC, 20));
        label3.setBounds(70, 140, 400, 30);

        // Load and scale the thought bubble image
        ImageIcon thoughtBubbleIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/thoughtbubble.png")));
        Image thoughtBubbleImg = thoughtBubbleIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledThoughtBubbleIcon = new ImageIcon(thoughtBubbleImg);

        // Create a JLabel with the thought bubble image
        JLabel thoughtBubbleLabel = new JLabel(scaledThoughtBubbleIcon);
        thoughtBubbleLabel.setBounds(-120, -50, 500, 400);

        // Load and scale the background image
        ImageIcon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Excited.png")));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImg);

        // Create a JLabel with the background image
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 800);

        // Initialize buttons
        button = new JButton("Balance");
        button.setBounds(600, 20, 150, 50);
        button.setFont(new Font("Serif", Font.ITALIC, 20));
        button.setForeground(new Color(0x0dc0f0a));
        button.setBackground(Color.white);
        button.setFocusable(false);
        button.addActionListener(this);

        button2 = new JButton("Deposit");
        button2.setBounds(600, 100, 150, 50);
        button2.setFont(new Font("Serif", Font.ITALIC, 20));
        button2.setForeground(new Color(0x0dc0f0a));
        button2.setBackground(Color.white);
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton("Withdraw");
        button3.setBounds(600, 180, 150, 50);
        button3.setFont(new Font("Serif", Font.ITALIC, 20));
        button3.setForeground(new Color(0x0dc0f0a));
        button3.setBackground(Color.white);
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4 = new JButton("Transfer");
        button4.setBounds(600, 260, 150, 50);
        button4.setFont(new Font("Serif", Font.ITALIC, 20));
        button4.setForeground(new Color(0x0dc0f0a));
        button4.setBackground(Color.white);
        button4.setFocusable(false);
        button4.addActionListener(this);

        // Create a layered pane to manage layering
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 800);

        // Add background first, then thought bubble, then components
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(thoughtBubbleLabel, Integer.valueOf(1));
        layeredPane.add(label, Integer.valueOf(2));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(label3, Integer.valueOf(2));
        layeredPane.add(button, Integer.valueOf(2));
        layeredPane.add(button2, Integer.valueOf(2));
        layeredPane.add(button3, Integer.valueOf(2));
        layeredPane.add(button4, Integer.valueOf(2));

        // Add layered pane to the frame
        this.setContentPane(layeredPane);
        this.setLayout(null);

        // Frame settings
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == button){
            new Balance(account);
        }
        if(e.getSource() == button2){
            new Deposit(account);
        }
        if(e.getSource() == button3){
            new Withdraw(account);
        }
        if(e.getSource() == button4){

            Account ronakAccount = new Account("Ronak", "Basnet", 10000, 55);
            Account hiranAccount = new Account("Hiran", "Patel", 1000, 11);

            new Transfer(ronakAccount, hiranAccount);
        }


    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Objects;

public class Balance extends JFrame implements ActionListener {

    JLabel label;
    JLabel label2;

    JLabel label3;

    JLabel SBK;


    Balance(Account account) {

        NumberFormat formatNum = NumberFormat.getNumberInstance();
        String formatBalance = formatNum.format(account.getBalance());



        label = new JLabel("Your current balance is: $" + formatBalance, JLabel.CENTER);
        label.setForeground(new Color(0x0dc0f0a));
        label.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 25));
        label.setBounds(185, 370, 405, 40);

        label2 = new JLabel("Choose the other options ", JLabel.CENTER);
        label2.setForeground(new Color(0x0dc0f0a));
        label2.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        label2.setBounds(185, 430, 410, 40);

        label3 = new JLabel("Press X to deposit, withdraw, or transfer !! ", JLabel.CENTER);
        label3.setForeground(new Color(0x0dc0f0a));
        label3.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
        label3.setBounds(95, 460, 600, 40);


        SBK = new JLabel("SBK", JLabel.CENTER);
        SBK.setForeground(new Color(0x0dc0f0a));
        SBK.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 40));
        SBK.setBounds(303, 590, 600, 40);


        ImageIcon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Balance.png")));
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
        layeredPane.add(label, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(1));
        layeredPane.add(SBK, Integer.valueOf(1));


        this.setContentPane(layeredPane);
        this.setLayout(null);
        this.setResizable(false);
       // this.add(label);
        this.setSize(800, 800);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

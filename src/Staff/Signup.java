package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Signup implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton button = new JButton("Login");
    private JPanel panel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();

    public Signup() {

        button.setBackground(Color.yellow);
        button.addActionListener(this);

        BoxLayout boxLayout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);

        textPanel.setLayout(null);
        username.setBounds(100, 250, 150, 30);
        password.setBounds(100, 290, 150, 30);
        button.setBounds(100, 330, 80, 25);
        textPanel.add(username);
        textPanel.add(password);
        textPanel.add(button);


        frame.setSize(300,500);
        frame.add(textPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Parking System");
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String user = username.getText();
        String pass = String.valueOf(password.getPassword());

        try {

            Scanner s = new Scanner(new File("customer.txt"));

            while(s.hasNext()) {
                String x = s.nextLine();
                int y = Integer.parseInt(s.nextLine());
                s.nextLine();
            }

        }

        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


    }
}

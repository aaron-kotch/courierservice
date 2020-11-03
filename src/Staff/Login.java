package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Login implements ActionListener {

    //Frames
    public JFrame frame = new JFrame();

    //Buttons
    private JButton button = new JButton("Login");

    //Panels
    private JPanel panel = new JPanel();
    private JPanel textPanel = new JPanel();

    //Text
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();

    public Login() {

        button.setBounds(100, 330, 80, 25);
        button.setBackground(Color.yellow);
        button.addActionListener(this);

        BoxLayout boxLayout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);

        textPanel.setLayout(null);
        username.setBounds(100, 250, 150, 30);
        password.setBounds(100, 290, 150, 30);

        textPanel.add(username);
        textPanel.add(password);
        textPanel.add(button);

        frame.setSize(300,500);
        frame.add(textPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String user = username.getText();
        String pass = String.valueOf(password.getPassword());

        for (int i = 0; i < Start.staffList.size(); i++) {

            Staff sT = Start.staffList.get(i);

            if (user.equals(sT.getName())) {
                System.out.println("user found");
                Start.loggedIn = sT;
            }
        }

        if (Start.loggedIn != null) {

            if (pass.equals(Start.loggedIn.getPassword())) {
                System.out.println("Login success!");
            }
            else {
                System.out.println("Incorrect details!");
            }
        }

    }
}



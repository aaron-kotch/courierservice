package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Login implements ActionListener {

    //Frames
    public JFrame frame = new JFrame();

    //Text
    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();

    public static String currentUser = null;

    public Login() {

        //Buttons
        JButton button = new JButton("Login");
        button.setBounds(100, 330, 80, 25);
        button.setBackground(Color.yellow);
        button.addActionListener(this);

        //Panels
        JPanel textPanel = new JPanel();

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

    public void getData() {

        String user = username.getText();
        String pass = String.valueOf(password.getPassword());
        String tempString;

        try {

            File file = new File("staffDetails.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();

                if (tempString.contains(user) && tempString.contains(pass)) {
                    currentUser = tempString;
                }

                s.nextLine();

            }

            System.out.println("Current User: " + currentUser);

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
                System.out.println(Start.loggedIn);
            }
            else {
                System.out.println("Incorrect details!");
            }

            if (Start.loggedIn.getRole().equals("Managing")) {
                frame.dispose();
                new Managing();
                getData();
            }

            else if (Start.loggedIn.getRole().equals("Delivery")) {
                frame.dispose();
                new Delivery();
                getData();
            }
        }
    }
}



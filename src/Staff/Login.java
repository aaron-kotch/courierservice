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
        button.setBackground(new Color(130, 177, 255));
        button.addActionListener(this);

        //Labels
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passLabel = new JLabel("Password: ");


        //Panels
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centPanel = new JPanel(new BorderLayout());
        JPanel bottPanel = new JPanel(new BorderLayout());

        username.setPreferredSize(new Dimension(100, 30));
        password.setPreferredSize(new Dimension(100, 30));

        topPanel.add(username, BorderLayout.PAGE_END);
        topPanel.add(usernameLabel, BorderLayout.PAGE_START);

        centPanel.add(password, BorderLayout.PAGE_END);
        centPanel.add(passLabel, BorderLayout.PAGE_START);
        bottPanel.add(button);

        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        passLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        topPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        centPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        bottPanel.setBorder(BorderFactory.createEmptyBorder(10,250,20,20));

        panel.add(topPanel);
        panel.add(centPanel);
        panel.add(bottPanel);

        frame.setSize(350,250);
        frame.add(panel, BorderLayout.CENTER);
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
            else {
                System.out.println("Incorrect details!");
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Incorrect Password!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }

        else {
            System.out.println("Incorrect details!");
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "User not found!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}



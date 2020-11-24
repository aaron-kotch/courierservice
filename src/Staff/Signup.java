package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Signup implements ActionListener {

    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();

    public Signup() {

        JButton button = new JButton("Login");
        button.setBackground(Color.yellow);
        button.addActionListener(this);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(null);

        username.setBounds(100, 250, 150, 30);
        password.setBounds(100, 290, 150, 30);
        button.setBounds(100, 330, 80, 25);
        textPanel.add(username);
        textPanel.add(password);
        textPanel.add(button);


        JFrame frame = new JFrame();
        frame.setSize(300,500);
        frame.add(textPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Signup");
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

            File file  = new File("customer.txt");
            System.out.println(user + "\n" + pass);

            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter writer = new FileWriter("customer.txt", true);
            writer.write(user + "\n" + pass + "\n\n");
            writer.close();
            
        }

        catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


    }
}

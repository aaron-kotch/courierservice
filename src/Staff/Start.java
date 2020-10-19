package Staff;

import java.lang.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start implements ActionListener{

    private static final JFrame startFrame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton login = new JButton("LOGIN");
    private static final JButton signup = new JButton("SIGN UP");

    public Start() {

        login.setBackground(Color.LIGHT_GRAY);
        login.addActionListener(this);

        signup.setBackground(Color.LIGHT_GRAY);
        signup.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(2, 0));
        panel.add(login);
        panel.add(signup);

        startFrame.setSize(300,300);
        startFrame.add(panel);
        startFrame.setLocationRelativeTo(null);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setTitle("Parking System");
        startFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new Start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            startFrame.dispose();
            new Login();
        }

        else if (e.getSource() == signup) {

            //startFrame.dispose();
            String x = JOptionPane.showInputDialog("Name:");
            System.out.println(x);
        }

    }
}

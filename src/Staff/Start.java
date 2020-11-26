package Staff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Start implements ActionListener{

    private static final JFrame startFrame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton login = new JButton("LOGIN");
    private static final JButton signup = new JButton("SIGN UP");

    public static Staff loggedIn = null;
    public static ArrayList<Staff> staffList = new ArrayList<>();

    static int x, y;

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

        try {
            File file  = new File("loginData.txt");

            if(!file.exists()){
                FileWriter fL  = new FileWriter(file);

                BufferedWriter bw = new BufferedWriter(fL);

                file.createNewFile();

                bw.write("admin\nadmin\nManaging\n\n");

                bw.close();
                fL.close();

            }

            Scanner s = new Scanner(file);


            while(s.hasNextLine()) {
                String x = s.nextLine();
                String y = s.nextLine();
                String z = s.nextLine();
                s.nextLine();
                Staff sT = new Staff(x, y, z);
                staffList.add(sT);
                System.out.println(staffList);
            }

            s.close();

        }

        catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

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

            startFrame.dispose();
            new Signup();
        }

    }
}

package Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delivery implements ActionListener {

    private static final JButton profButton = new JButton("View Profile");
    private static final JButton taskButton = new JButton("View Tasks");
    private static final  JFrame frame = new JFrame();

    public Delivery() {

        // buttons
        profButton.setBounds(100, 100, 150, 50);

        taskButton.addActionListener(this);
        taskButton.setBounds(300, 100, 150, 50);

        // panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(profButton);
        panel.add(taskButton);

        profButton.addActionListener(this);
        taskButton.addActionListener(this);

        // frame
        frame.setSize(550, 500);
        frame.setTitle("Menu");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Delivery();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == profButton) {
            frame.dispose();
            new Profile();
        }

        if (e.getSource() == taskButton) {
            
            System.out.println("No action");
        }
    }
}

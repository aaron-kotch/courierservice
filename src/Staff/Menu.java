package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    private JButton button = new JButton("Hello");
    private JPanel panel = new JPanel();

    public Menu() {

        button.setBackground(Color.yellow);
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Parking System");
        pack();

    }

    public static void main(String[] args) {
        new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

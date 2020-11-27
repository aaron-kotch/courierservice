package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class Delivery implements ActionListener {

    private final JButton profButton = new JButton("View Profile");
    private final JButton taskButton = new JButton("View Tasks");
    private JFrame frame;

    public Delivery() {

        frame = new JFrame();


        // panel
        JLabel title = new JLabel("MENU");
        title.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        profButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        taskButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        JPanel panel = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());

        title.setBorder(BorderFactory.createEmptyBorder(20,100,20,90));
        left.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        right.setBorder(BorderFactory.createEmptyBorder(0,20,50,20));

        left.add(title, BorderLayout.PAGE_START);
        left.add(profButton, BorderLayout.PAGE_END);
        right.add(taskButton, BorderLayout.CENTER);

        panel.add(left, BorderLayout.PAGE_START);
        panel.add(right, BorderLayout.PAGE_END);

        profButton.addActionListener(this);
        taskButton.addActionListener(this);

        // frame
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == profButton) {

            profButton.removeActionListener(this);
            frame.dispose();
            new Profile();
        }

        if (e.getSource() == taskButton) {

            frame.dispose();
            taskButton.removeActionListener(this);
            new updateStatus();
        }
    }
}

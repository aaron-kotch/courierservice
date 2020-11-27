package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class customerMenu implements ActionListener {

    private final JButton addButton = new JButton("Create Order");
    private final JButton viewButton = new JButton("View Orders");
    private final JButton feedButton = new JButton("View Feedbacks");
    private final JButton backButton = new JButton("Back");
    private JFrame frame;

    public customerMenu() {

        frame = new JFrame();

        // buttons

        // panel
        JLabel title = new JLabel("ORDER MENU");
        title.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        addButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        viewButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        feedButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        JPanel panel = new JPanel(new GridLayout(6, 1));
        JPanel left = new JPanel(new BorderLayout());
        JPanel left1 = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        JPanel right1 = new JPanel(new BorderLayout());
        JPanel backPanel = new JPanel(new BorderLayout());

        title.setBorder(BorderFactory.createEmptyBorder(40,70,20,0));
        left.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        left1.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        right.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        right1.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        backPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        left.add(title, BorderLayout.CENTER);
        left1.add(addButton, BorderLayout.CENTER);
        right.add(viewButton, BorderLayout.CENTER);
        right1.add(feedButton, BorderLayout.CENTER);
        backPanel.add(backButton, BorderLayout.CENTER);

        panel.add(left);
        panel.add(left1);
        panel.add(right);
        panel.add(right1);
        panel.add(backPanel);

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        feedButton.addActionListener(this);
        backButton.addActionListener(this);

        // frame
        frame.setSize(300, 350);
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

        if (e.getSource() == addButton) {

            addButton.removeActionListener(this);
            viewButton.removeActionListener(this);
            feedButton.removeActionListener(this);
            backButton.removeActionListener(this);
            frame.dispose();
            new CustomerForm();
        }

        if (e.getSource() == viewButton) {

            addButton.removeActionListener(this);
            viewButton.removeActionListener(this);
            feedButton.removeActionListener(this);
            backButton.removeActionListener(this);
            frame.dispose();
            new customerList();
        }

        if (e.getSource() == feedButton) {

            addButton.removeActionListener(this);
            viewButton.removeActionListener(this);
            feedButton.removeActionListener(this);
            backButton.removeActionListener(this);
            frame.dispose();
            new viewFeedback();
        }

        if (e.getSource() == backButton) {

            addButton.removeActionListener(this);
            viewButton.removeActionListener(this);
            feedButton.removeActionListener(this);
            backButton.removeActionListener(this);
            frame.dispose();
            new Managing();
        }

    }
}

package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class customerMenu implements ActionListener {

    private static final JButton addButton = new JButton("Create Order");
    private static final JButton viewButton = new JButton("View Orders");
    private static final JButton feedButton = new JButton("View Feedbacks");
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
        JPanel panel = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());

        title.setBorder(BorderFactory.createEmptyBorder(20,70,20,0));
        left.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        right.setBorder(BorderFactory.createEmptyBorder(0,20,50,20));

        left.add(title, BorderLayout.PAGE_START);
        left.add(addButton, BorderLayout.PAGE_END);
        right.add(viewButton, BorderLayout.CENTER);
        right.add(feedButton, BorderLayout.PAGE_END);

        panel.add(left, BorderLayout.PAGE_START);
        panel.add(right, BorderLayout.PAGE_END);

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        feedButton.addActionListener(this);

        // frame
        frame.setSize(300, 250);
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
            frame.dispose();
            new CustomerForm();
        }

        if (e.getSource() == viewButton) {

            addButton.removeActionListener(this);
            viewButton.removeActionListener(this);
            feedButton.removeActionListener(this);
            frame.dispose();
            new customerList();
        }

        if (e.getSource() == feedButton) {

            addButton.removeActionListener(this);
            viewButton.removeActionListener(this);
            feedButton.removeActionListener(this);
            frame.dispose();
            new viewFeedback();
        }

    }
}

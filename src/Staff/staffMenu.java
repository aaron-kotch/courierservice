package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staffMenu implements ActionListener {

    private static final JButton addButton = new JButton("Add Staff");
    private static final JButton viewButton = new JButton("View Staffs");
    private static final JButton assignButton = new JButton("Assign Orders");
    private static final JButton backButton = new JButton("Back");
    private final JFrame frame = new JFrame();

    public staffMenu() {

        addButton.addActionListener(this);
        addButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));

        viewButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        viewButton.addActionListener(this);

        assignButton.addActionListener(this);
        assignButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));

        backButton.addActionListener(this);
        backButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));

        JLabel title = new JLabel("STAFF MENU", SwingConstants.CENTER);
        title.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        JPanel panel = new JPanel(new GridLayout(6, 1));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel bottPanel = new JPanel(new BorderLayout());
        JPanel bottPanel1 = new JPanel(new BorderLayout());

        topPanel.add(addButton, BorderLayout.CENTER);
        centerPanel.add(viewButton, BorderLayout.CENTER);
        bottPanel.add(assignButton, BorderLayout.CENTER);
        bottPanel1.add(backButton, BorderLayout.CENTER);

        title.setBorder(BorderFactory.createEmptyBorder(50,0,30,0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        bottPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        bottPanel1.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));

        panel.add(title);
        panel.add(topPanel);
        panel.add(centerPanel);
        panel.add(bottPanel);
        panel.add(bottPanel1);

        frame.setSize(300, 320);
        frame.setTitle("View Staff");
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new staffMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            clearListener();
            frame.dispose();
            new addStaff();
        }

        if (e.getSource() == viewButton) {
            clearListener();
            frame.dispose();
            new staffList();
        }

        if (e.getSource() == assignButton) {
            clearListener();
            frame.dispose();
            new assignOrders();
        }

        if (e.getSource() == backButton) {
            clearListener();
            frame.dispose();
            new Managing();
        }
    }

    public void clearListener() {

        addButton.removeActionListener(this);
        viewButton.removeActionListener(this);
        assignButton.removeActionListener(this);
        backButton.removeActionListener(this);

    }
}

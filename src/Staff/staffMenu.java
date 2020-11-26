package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staffMenu implements ActionListener {

    private static final JButton addButton = new JButton("Add Staff");
    private static final JButton viewButton = new JButton("View Staffs");
    private static final JButton assignButton = new JButton("Assign Orders");
    private static final  JFrame frame = new JFrame();

    public staffMenu() {


        addButton.addActionListener(this);

        viewButton.addActionListener(this);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(2, 2));
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(assignButton);

        frame.setSize(550, 500);
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
            frame.dispose();
            new addStaff();
        }

        if (e.getSource() == viewButton) {
            frame.dispose();
            new staffList();
        }

        if (e.getSource() == assignButton) {
            frame.dispose();
            new assignOrders();
        }
    }
}

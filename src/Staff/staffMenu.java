package Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staffMenu implements ActionListener {

    private static final JButton addButton = new JButton("Add Staff");
    private static final JButton editButton = new JButton("Edit Staff Info");
    private static final JButton viewButton = new JButton("View Staffs");
    private static final  JFrame frame = new JFrame();

    public staffMenu() {


        addButton.addActionListener(this);
        addButton.setBounds(100, 100, 150, 50);


        viewButton.addActionListener(this);
        viewButton.setBounds(300, 100, 150, 50);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(addButton);
        panel.add(viewButton);

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
    }
}

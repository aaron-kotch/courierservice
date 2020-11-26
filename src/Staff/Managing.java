package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Managing implements ActionListener {

    // add staff info - name, phone, username, id, email, rank.
    // customer info - name, email, phone, address, id
    private static final JButton staffButton = new JButton("Manage Staff");
    private static final JButton custButton = new JButton("Manage Customer");
    private static final  JFrame frame = new JFrame();

    public Managing() {

        // buttons
        staffButton.addActionListener(this);

        custButton.addActionListener(this);

        // panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(staffButton);
        panel.add(custButton);

        // frame
        frame.setSize(550, 500);
        frame.setTitle("Manage");
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Managing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == staffButton) {

            frame.dispose();
            new staffMenu();

        }

        if (e.getSource() == custButton) {

            frame.dispose();

        }
    }
}

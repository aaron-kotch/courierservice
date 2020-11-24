package Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Managing implements ActionListener {

    // add staff info - name, phone, username, id, email, rank.
    // customer info - name, email, phone, address, id

    public Managing() {

        JButton staffButton = new JButton("Manage Staff");
        staffButton.addActionListener(this);
        staffButton.setBounds(100, 100, 150, 50);

        JButton custButton = new JButton("Manage Customer");
        custButton.addActionListener(this);
        custButton.setBounds(300, 100, 150, 50);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(staffButton);
        panel.add(custButton);

        JFrame frame = new JFrame();
        frame.setSize(550, 500);
        frame.setTitle("Manage");
        frame.add(panel);
        frame.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

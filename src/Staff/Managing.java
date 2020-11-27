package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Managing implements ActionListener {

    private static final JButton staffButton = new JButton("Manage Staff");
    private static final JButton custButton = new JButton("Manage Orders");
    private final JFrame frame = new JFrame();

    public Managing() {

        JLabel title = new JLabel("MENU", SwingConstants.CENTER);
        title.setFont(new Font("Source Sans Pro", Font.BOLD, 18));

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bottPanel = new JPanel(new BorderLayout());

        // buttons
        staffButton.addActionListener(this);
        custButton.addActionListener(this);

        staffButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
        custButton.setFont(new Font("Source Sans Pro", Font.BOLD, 14));

        // panel
        topPanel.add(title, BorderLayout.PAGE_START);
        topPanel.add(staffButton, BorderLayout.CENTER);
        bottPanel.add(custButton, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(bottPanel, BorderLayout.PAGE_END);

        title.setBorder(BorderFactory.createEmptyBorder(30,0,50,0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        bottPanel.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));

        // frame
        frame.setSize(300, 260);
        frame.setTitle("Manage");
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == staffButton) {

            clearListener();
            frame.dispose();
            new staffMenu();

        }

        if (e.getSource() == custButton) {

            clearListener();
            frame.dispose();
            new customerMenu();

        }

    }

    public void clearListener() {

        staffButton.removeActionListener(this);
        custButton.removeActionListener(this);

    }
}

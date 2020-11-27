package Staff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStaff implements ActionListener {

    private final JFrame frame;
    private final JPanel panel;
    private static final JButton save = new JButton("Save");
    private static final JButton back = new JButton("Cancel");

    private static final JTextField name = new JTextField();
    private static final JTextField phone = new JTextField();
    private static final JTextField id = new JTextField();
    private static final JTextField email = new JTextField();
    private static final JTextField role = new JTextField();
    private static final JTextField username = new JTextField();
    private static final JPasswordField password = new JPasswordField();

    public addStaff() {

        frame = new JFrame();
        panel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Contact number:");
        JLabel idLabel = new JLabel("ID number:");
        JLabel emailLabel = new JLabel("E-mail:");
        JLabel roleLabel = new JLabel("Role (Managing/Delivery):");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        nameLabel.setPreferredSize(new Dimension(50, 100));
        phoneLabel.setPreferredSize(new Dimension(50, 100));
        idLabel.setPreferredSize(new Dimension(50, 100));
        emailLabel.setPreferredSize(new Dimension(50, 100));
        roleLabel.setPreferredSize(new Dimension(50, 100));

        name.setPreferredSize(new Dimension(200, 100));
        phone.setPreferredSize(new Dimension(200, 100));
        id.setPreferredSize(new Dimension(200, 100));
        email.setPreferredSize(new Dimension(200, 100));
        role.setPreferredSize(new Dimension(200, 100));

        JPanel left = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBorder( new LineBorder(Color.BLUE) );
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        left.add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        left.add(phoneLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        left.add(idLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        left.add(emailLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        left.add(roleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        left.add(usernameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        left.add(passLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        left.add(back, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        left.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        left.add(phone, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        left.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        left.add(email, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        left.add(role, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        left.add(username, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        left.add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        left.add(save, gbc);

        left.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.setLayout(new BorderLayout());
        panel.add(left, BorderLayout.CENTER);


        // frame
        frame.setSize(400, 400);
        frame.setTitle("Manage");
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

        save.addActionListener(this);
        back.addActionListener(this);

    }

    public static void main(String[] args) {
        new addStaff();
    }

    public void writeText() {

        String getName = addStaff.name.getText();
        String getPhone = addStaff.phone.getText();
        String getId = addStaff.id.getText();
        String getEmail = addStaff.email.getText();
        String getRole = addStaff.role.getText();
        String getUsername = addStaff.username.getText();
        String getPass = addStaff.password.getText();
        String getStatus = "Available";

        try {
            File file = new File("staffDetails.txt");
            File loginFile  = new File("loginData.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            if (!loginFile.exists()) {
                file.createNewFile();
            }

            FileWriter fw  = new FileWriter(file, true);
            FileWriter fL  = new FileWriter(loginFile, true);

            System.out.println("Ok");
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedWriter bL = new BufferedWriter(fL);

            bL.write(getUsername + "\n" + getPass + "\n" + getRole + "\n\n");
            bw.write(getId + "/" + getName + "/" + getEmail + "/" + getPhone + "/" + getRole + "/" + getUsername + "/" + getPass + "/" + getStatus + "\n");
            bL.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {

            frame.dispose();
            save.removeActionListener(this);
            back.removeActionListener(this);
            writeText();
            new staffMenu();

        }

        if (e.getSource() == back) {

            frame.dispose();
            save.removeActionListener(this);
            back.removeActionListener(this);
            new staffMenu();

        }
    }
}


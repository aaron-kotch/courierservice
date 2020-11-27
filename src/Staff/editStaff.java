package Staff;

import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class editStaff implements ActionListener {

    public static String fromWhere;

    private static final String nName = staffList.tName;
    private static final String nPhone = staffList.tPhone;
    private static final String nId = staffList.tId;
    private static final String nEmail = staffList.tEmail;
    private static final String nRole = staffList.tRole;
    private static final String nUsername = staffList.tUsername;
    private static final String nPass = staffList.tPass;

    private static final String pName = Profile.tName;
    private static final String pPhone = Profile.tPhone;
    private static final String pId = Profile.tId;
    private static final String pEmail = Profile.tEmail;
    private static final String pRole = Profile.tRole;
    private static final String pUsername = Profile.tUsername;
    private static final String pPass = Profile.tPass;
    private static final String pStatus = Profile.tStatus;

    private static final JLabel nameLabel = new JLabel("Name:");
    private static final JLabel phoneLabel = new JLabel("Contact number:");
    private static final JLabel idLabel = new JLabel("ID number:");
    private static final JLabel emailLabel = new JLabel("E-mail:");
    private static final JLabel roleLabel = new JLabel("Role:");
    private static final JLabel usernameLabel = new JLabel("Username:");
    private static final JLabel passLabel = new JLabel("Password:");

    private JFrame frame;
    private JPanel panel;
    private static final JButton save = new JButton("Save");

    public static String editLine;

    public static final JTextField name = new JTextField();
    public static final JTextField phone = new JTextField();
    public static final JTextField id = new JTextField();
    public static final JTextField email = new JTextField();
    public static final JTextField role = new JTextField();
    public static final JTextField username = new JTextField();
    public static final JPasswordField password = new JPasswordField();

    public editStaff() {

        frame = new JFrame();
        panel = new JPanel();

        if (fromWhere.equals("staffList")) {
            name.setText(nName);
            phone.setText(nPhone);
            id.setText(nId);
            email.setText(nEmail);
            role.setText(nRole);
            username.setText(nUsername);
            password.setText(nPass);

            System.out.println("from staffList");
        }

        else if (fromWhere.equals("Profile")) {
            name.setText(pName);
            phone.setText(pPhone);
            id.setText(pId);
            email.setText(pEmail);
            role.setText(pRole);
            username.setText(pUsername);
            password.setText(pPass);
            System.out.println("from profile");
        }

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

        panel.setLayout(new BorderLayout());
        panel.add(left, BorderLayout.CENTER);

        save.addActionListener(this);

        // frame
        frame.setSize(300, 400);
        frame.setTitle("Manage");
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {
            save.removeActionListener(this);
            frame.dispose();
            editText();

            if (fromWhere.equals("staffList")) {
                new staffList();
            }

            if (fromWhere.equals("Profile")) {
                new Profile();
            }
        }
    }

    public static void editText() {

        String getName = editStaff.name.getText();
        String getPhone = editStaff.phone.getText();
        String getId = editStaff.id.getText();
        String getEmail = editStaff.email.getText();
        String getRole = editStaff.role.getText();
        String getUsername = editStaff.username.getText();
        String getPass = editStaff.password.getText();
        String getStatus = editStaff.pStatus;

        String newData;

        String tempString = null;

        try {
            File file = new File("staffDetails.txt");
            File tempFile = new File("tempStaffFile.txt");

            Scanner s = new Scanner(file);

            if (!file.exists()) {
                file.createNewFile();
            }
            if (!tempFile.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            newData = getId + "/" + getName + "/" + getEmail + "/" + getPhone + "/" + getRole + "/" + getUsername + "/" + getPass + "/" + getStatus;

            System.out.println("DATA " + newData);

            while (s.hasNextLine()) {
                tempString = s.next();

                if (!tempString.equals(editStaff.editLine)) {
                    writer.write(tempString);
                    writer.newLine();
                    s.nextLine();
                }
                else {
                    writer.write(newData);
                    writer.newLine();
                    s.nextLine();
                }
            }

            s.close();
            writer.close();
            reader.close();

            boolean yes = file.delete();
            System.out.println(yes);

            boolean success = tempFile.renameTo(file);

            System.out.println(success);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

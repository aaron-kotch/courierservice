package Staff;

import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class editProfile implements ActionListener {

    private static final String nName = Profile.tName;
    private static final String nPhone = Profile.tPhone;
    private static final String nId = Profile.tId;
    private static final String nEmail = Profile.tEmail;
    private static final String nRole = Profile.tRole;
    private static final String nUsername = Profile.tUsername;
    private static final String nPass = Profile.tPass;

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton save = new JButton("Save");

    public static final String editLine = staffList.toEdit;

    public static final JTextField name = new JTextField(nName);
    public static final JTextField phone = new JTextField(nPhone);
    public static final JTextField id = new JTextField(nId);
    public static final JTextField email = new JTextField(nEmail);
    public static final JTextField role = new JTextField(nRole);
    public static final JTextField username = new JTextField(nUsername);
    public static final JTextField password = new JTextField(nPass);

    public editProfile() {

        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Contact number:");
        JLabel idLabel = new JLabel("ID number:");
        JLabel emailLabel = new JLabel("E-mail:");
        JLabel roleLabel = new JLabel("Role:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passeLabel = new JLabel("Password:");

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
        gbc.gridy = 4;
        left.add(roleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        left.add(roleLabel, gbc);

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
        left.add(save, gbc);

        panel.setLayout(new BorderLayout());
        panel.add(left, BorderLayout.CENTER);

        // frame
        frame.setSize(300, 300);
        frame.setTitle("Manage");
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

        save.addActionListener(this);

    }

    public static void main(String[] args) {
        new addStaff();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {
            new editDeliveryText();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}

class editDeliveryText {

    String getName = editStaff.name.getText();
    String getPhone = editStaff.phone.getText();
    String getId = editStaff.id.getText();
    String getEmail = editStaff.email.getText();
    String getRole = editStaff.role.getText();

    String newData;

    public editDeliveryText() {

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

            newData = getName + "/" + getPhone + "/" + getId + "/" + getEmail + "/" + getRole;

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

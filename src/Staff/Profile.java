package Staff;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profile {

    ListSelectionModel listSelectionModel;

    private JFrame frame = new JFrame();
    private JPanel leftPanel;
    private JPanel rightPanel;

    JTextArea output;

    public static JLabel name = new JLabel("Name:");
    public static JLabel phone = new JLabel("Contact number:");
    public static JLabel id = new JLabel("E-mail:");
    public static JLabel email = new JLabel("Id:");
    public static JLabel role = new JLabel("Role:");
    public static JLabel usernameLabel = new JLabel("Username:");
    public static JLabel passLabel = new JLabel("Password:");

    public static JScrollPane scrollPane = new JScrollPane();

    public static JLabel nameResult = new JLabel();
    public static JLabel phoneResult = new JLabel();
    public static JLabel idResult = new JLabel();
    public static JLabel emailResult= new JLabel();
    public static JLabel roleResult = new JLabel();
    public static JLabel usernameResult = new JLabel();
    public static JLabel passResult = new JLabel();

    public static String tName;
    public static String tPhone;
    public static String tId;
    public static String tEmail;
    public static String tRole;
    public static String tUsername;
    public static String tPass;

    public static String fOrderId;
    public static String fStaffId;
    public static String fName;
    public static String fRating;
    public static String fComment;

    private static final String userFull = Login.currentUser;
    public static ArrayList<staffData> newList = new ArrayList<>();
    public static ArrayList<feedData> newFeedList = new ArrayList<>();
    public static List<String> getData = new ArrayList<>();

    //feedback
    public static ArrayList<String> feedback = new ArrayList<>();
    public static String[] feedSplit;
    final DefaultListModel<String> model = new DefaultListModel<>();
    public JList<String> sList;

    boolean isSelect;

    public Profile() {

        updateData();

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        JPanel panel = new JPanel(new GridLayout(1, 3));
        JPanel bottomPanel = new JPanel();
        leftPanel = new JPanel(new GridBagLayout());
        rightPanel = new JPanel(new GridLayout(5, 1));

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 50, 10, 20);

        // first column
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(phone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        leftPanel.add(id, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        leftPanel.add(email, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        leftPanel.add(role, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        leftPanel.add(usernameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        leftPanel.add(passLabel, gbc);

        // second column
        gbc.gridx = 1;
        gbc.gridy = 0;
        leftPanel.add(nameResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        leftPanel.add(phoneResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        leftPanel.add(idResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        leftPanel.add(emailResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        leftPanel.add(roleResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        leftPanel.add(usernameResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        leftPanel.add(passResult, gbc);

        panel.setLayout(new GridLayout(1, 2));
        panel.add(leftPanel);
        panel.add(rightPanel);

        output = new JTextArea(10, 10);
        output.setEditable(false);
        output.setVisible(true);
        JScrollPane outputPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        scrollPane.setViewportView(sList);
        sList.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);

        mainPanel.add(outputPane);

        // frame
        frame.add(panel);
        frame.setSize(550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Profile");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new Profile();
    }

    public void updateData() {

        String[] userSplit = userFull.split("/"); //splits line
        staffData sL = new staffData(userSplit[0], userSplit[1], userSplit[2], userSplit[3], userSplit[4], userSplit[5], userSplit[6]);
        newList.add(sL);
        System.out.println(newList);

        staffData sD = newList.get(0);
        nameResult.setText(sD.getName());
        phoneResult.setText(sD.getPhone());
        idResult.setText(sD.getId());
        emailResult.setText(sD.getEmail());
        roleResult.setText(sD.getRole());
        usernameResult.setText(sD.getUsername());
        passResult.setText(sD.getPassword());

        tName = sD.getName();
        tPhone = sD.getRole();
        tId = sD.getId();
        tEmail = sD.getEmail();
        tRole = sD.getRole();
        tUsername = sD.getUsername();
        tPass = sD.getPassword();

        getFeedback();

    }

    public void getFeedback() {

        String tempString;

        try {

            File file = new File("customer.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();

                if (tempString.contains(tId)) {

                    feedback.add(tempString);
                    feedSplit = tempString.split("/"); //splits line
                    s.nextLine();
                    feedData sF = new feedData(feedSplit[0], feedSplit[1], feedSplit[2], feedSplit[3], feedSplit[4]);
                    newFeedList.add(sF);
                    System.out.println(newList);
                }
            }

            s.close();

            int i = 0;

            while (i < newFeedList.size()) {

                feedData sD = newFeedList.get(i);
                String data = sD.getOrderId() + " | " + sD.getStaffId() + " | " + sD.getName() + " | " + sD.getRating() + " | " + sD.getComment();
                getData.add(data);
                System.out.println(data);
                model.addElement(getData.get(i));
                i++;

            }

            sList = new JList<>(model);

            listSelectionModel = sList.getSelectionModel();
            listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());

            System.out.println("Model = " + model);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class SharedListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel listSel = (ListSelectionModel)e.getSource();

            int firstIndex = e.getFirstIndex();

            if (listSel.isSelectionEmpty()) {
                isSelect = true;
                System.out.println(" <none> ");
            }
            else {
                isSelect = false;
                int minIndex = listSel.getMinSelectionIndex();
                int maxIndex = listSel.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (listSel.isSelectedIndex(i)) {
                        System.out.println(" index: " + i);

                        feedData sD = newFeedList.get(i);

                        fOrderId = sD.getOrderId();
                        fStaffId = sD.getStaffId();
                        fName = sD.getName();
                        fRating = sD.getRating();
                        fComment = sD.getComment();


                    }
                }
            }

        }
    }
}



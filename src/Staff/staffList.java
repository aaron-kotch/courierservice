package Staff;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class staffList implements ActionListener {

    JTextArea output;
    ListSelectionModel listSelectionModel;

    public static ArrayList<String> staffFull = new ArrayList<>();
    public static List<String> getData = new ArrayList<>();
    public static String[] staffSplit;
    public static ArrayList<staffData> newList = new ArrayList<>();

    public static JTextField searchTF = new JTextField();
    public static JButton searchButton = new JButton("Search");
    public static JButton delButton = new JButton("Delete");
    public static JButton addButton = new JButton("Add");
    public static JButton editButton = new JButton("Edit");
    public static JScrollPane scrollPane = new JScrollPane();

    public static JLabel nameResult = new JLabel();
    public static JLabel phoneResult = new JLabel();
    public static JLabel idResult = new JLabel();
    public static JLabel emailResult= new JLabel();
    public static JLabel roleResult = new JLabel();

    public static JPanel topPanel = new JPanel();

    public static String tName;
    public static String tPhone;
    public static String tId;
    public static String tEmail;
    public static String tRole;
    public static String tUsername;
    public static String tPass;

    public static String toEdit;

    private boolean isSelect;


    static  JFrame frame;
    final DefaultListModel<String> model = new DefaultListModel<>();
    public JList<String> sList;

    public static String deleteLine;

    public staffList() {
        updateStaff();

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //search panel
        gbc.insets = new Insets(0, 10, 0, 0);
        searchPanel.add(searchTF, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 10, 10, 5);
        searchPanel.add(searchButton, gbc);
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));

        frame = new JFrame("Staff Details");

        int i = 0;

        while (i < newList.size()) {

            staffData sD = newList.get(i);
            String data = sD.getId() + " | " + sD.getName() + " | " + sD.getPhone() + " | " + sD.getEmail() + " | " + sD.getRole();
            getData.add(data);
            System.out.println(data);
            model.addElement(getData.get(i));
            i++;

        }

        sList = new JList<>(model);

        listSelectionModel = sList.getSelectionModel();
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        scrollPane.setViewportView(sList);
        sList.setLayoutOrientation(JList.VERTICAL);
        topPanel.add(searchPanel);
        topPanel.add(scrollPane);

        JPanel listContainer = new JPanel(new GridLayout(1, 1));
        listContainer.setBorder(BorderFactory.createTitledBorder("List"));
        listContainer.add(scrollPane);

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
        topPanel.add(listContainer);

        topPanel.setMinimumSize(new Dimension(400, 200));
        topPanel.setMaximumSize(new Dimension(400, 200));

        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Contact No.:");
        JLabel idLabel = new JLabel("ID number:");
        JLabel emailLabel = new JLabel("E-mail:");
        JLabel roleLabel = new JLabel("Role:");

        JPanel left = new JPanel(new GridBagLayout());

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 50, 10, 20);

        // first column
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

        // second column
        gbc.gridx = 1;
        gbc.gridy = 0;
        left.add(nameResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        left.add(phoneResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        left.add(idResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        left.add(emailResult, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        left.add(roleResult, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(delButton);

        addButton.addActionListener(this);
        editButton.addActionListener(this);

        delButton.addActionListener(this);
        delButton.setBackground(Color.red);

        output = new JTextArea(10, 10);
        output.setEditable(false);
        output.setVisible(false);
        JScrollPane outputPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(left, BorderLayout.LINE_START);
        bottomPanel.setPreferredSize(new Dimension(400, 300));
        bottomPanel.add(buttonPanel, BorderLayout.LINE_END);

        splitPane.add(topPanel);
        splitPane.add(bottomPanel);

        frame.add(splitPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new staffList();

    }

    public void updateStaff() {
        newList.clear();

        String tempString;

        try {

            File file = new File("staffDetails.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();
                staffFull.add(tempString);
                staffSplit = tempString.split("/"); //splits line
                s.nextLine();
                staffData sL = new staffData(staffSplit[0], staffSplit[1], staffSplit[2], staffSplit[3], staffSplit[4], staffSplit[5], staffSplit[6]);
                newList.add(sL);
                System.out.println(staffFull);
            }

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeLine() {

        String tempString = null;

        try {

            int index = 0;

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

            while (s.hasNextLine()) {
                tempString = s.next();

                if (!tempString.equals(deleteLine)) {
                    writer.write(tempString);
                    writer.newLine();
                    s.nextLine();
                }
                else {
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

    public void filterLine() {

        String input = searchTF.getText();

        newList.clear();
        sList.removeAll();
        model.removeAllElements();

        String tempString = null;

        try {

            File file = new File("staffDetails.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            int index = 0;
            int i = 0;

            while (s.hasNextLine()) {
                tempString = s.next();

                if (tempString.contains(input)) {
                    staffFull.add(tempString);
                    staffSplit = tempString.split("/"); //splits line
                    staffData sL = new staffData(staffSplit[0], staffSplit[1], staffSplit[2], staffSplit[3], staffSplit[4], staffSplit[5], staffSplit[6]);
                    newList.add(sL);
                    System.out.println(tempString);
                    s.nextLine();
                }
                else {
                    s.nextLine();
                }

                while (i < newList.size()) {

                    staffData sD = newList.get(i);
                    String data = sD.getId() + " | " + sD.getName() + " | " + sD.getPhone() + " | " + sD.getEmail() + " | " + sD.getRole();
                    getData.add(data);
                    System.out.println(data);
                    model.addElement(getData.get(index));
                    i++;

                }

                index++;

                System.out.println("LIst = " + newList);
            }

            sList = new JList<>(model);

            listSelectionModel = sList.getSelectionModel();
            listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());

            System.out.println("Model = " + model);

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == delButton) {
            int index = sList.getSelectedIndex();
            model.remove(index);

            deleteLine = staffFull.get(index);
            System.out.println("HOLA " + deleteLine);
            removeLine();
            updateStaff();

            int size = model.getSize();

            if (index == model.getSize()) {
                index--;
            }
            sList.setSelectedIndex(index);
            sList.ensureIndexIsVisible(index);

        }

        if (e.getSource() == searchButton) {
            filterLine();
        }

        if (e.getSource() == addButton) {
            new addStaff();
        }

        if (e.getSource() == editButton) {

            new editStaff();


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

                        staffData sD = newList.get(i);
                        nameResult.setText(sD.getName());
                        phoneResult.setText(sD.getPhone());
                        idResult.setText(sD.getId());
                        emailResult.setText(sD.getEmail());
                        roleResult.setText(sD.getRole());

                        tName = sD.getName();
                        tPhone = sD.getRole();
                        tId = sD.getId();
                        tEmail = sD.getEmail();
                        tRole = sD.getRole();
                        tUsername = sD.getUsername();
                        tPass = sD.getPassword();

                        toEdit = staffFull.get(i);

                        System.out.println(toEdit);


                    }
                }
            }

        }
    }

}


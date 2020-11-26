package Staff;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class viewFeedback implements ActionListener {

    ListSelectionModel listSelectionModel;

    JTextArea output;

    JFrame frame = new JFrame();

    public static JScrollPane scrollPane = new JScrollPane();

    public static JButton backButton = new JButton("Back");

    public static String fOrderId;
    public static String fStaffId;
    public static String fName;
    public static String fRating;
    public static String fComment;

    private static final String userFull = Login.currentUser;
    public static ArrayList<staffData> newList = new ArrayList<>();
    public static ArrayList<feedData> newFeedList = new ArrayList<>();
    public static List<String> getData = new ArrayList<>();
    public static List<String> getModelData = new ArrayList<>();

    //feedback
    public static ArrayList<String> feedback = new ArrayList<>();
    public static String[] feedSplit;
    final DefaultListModel<String> model = new DefaultListModel<>();
    public JList<String> sList;

    boolean isSelect;

    public viewFeedback() {

        getFeedback();

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));

        backButton.addActionListener(this);

        buttonPanel.add(backButton);

        output = new JTextArea(10, 10);
        output.setEditable(false);
        JScrollPane outputPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setViewportView(sList);
        sList.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);

        scrollPane.setBorder(BorderFactory.createTitledBorder("Orders"));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Details"));
        outputPane.setBorder(BorderFactory.createTitledBorder("Feedbacks"));

        bottomPanel.add(outputPane, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.PAGE_END);
        mainPanel.add(panel);
        mainPanel.add(bottomPanel);



        // frame
        frame.add(mainPanel);
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Profile");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new viewFeedback();
    }

    public void getFeedback() {

        model.removeAllElements();
        newFeedList.clear();

        System.out.println("STARTLINE");

        String tempString;

        try {

            File file = new File("customer.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();

                feedback.add(tempString);
                feedSplit = tempString.split("/"); //splits line
                feedData sF = new feedData(feedSplit[0], feedSplit[1], feedSplit[2], feedSplit[3], feedSplit[4]);
                newFeedList.add(sF);
                System.out.println(newFeedList);
                s.nextLine();

            }

            s.close();

            int i = 0;

            while (i < newFeedList.size()) {

                feedData sD = newFeedList.get(i);
                String data = sD.getOrderId() + " | " + sD.getStaffId() + " | " + sD.getName() + " | " + sD.getRating() + " | " + sD.getComment();
                getData.add(data);
                getModelData.add(sD.getOrderId());
                System.out.println(data);
                model.addElement(String.valueOf(getModelData.get(i)));
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            frame.dispose();
            new staffMenu();
        }
    }

    class SharedListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel listSel = (ListSelectionModel)e.getSource();

            output.setText(null);

            int firstIndex = e.getFirstIndex();

            if (listSel.isSelectionEmpty()) {
                isSelect = true;
                output.append(" <none> ");
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

                        output.append(fOrderId + "\n" + fName + "\n" + fRating + "\n" + fComment);


                    }
                }
            }

        }
    }
}




package Staff;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class updateStatus implements ItemListener {

    public static ArrayList<String> orderFull = new ArrayList<>();
    public static String[] orderSplit;
    public static ArrayList<pendingData> newOrderList = new ArrayList<>();
    public static List<String> getOrderData = new ArrayList<>();

    public static ArrayList<String> staffFull = new ArrayList<>();
    public static String[] staffSplit;
    public static ArrayList<staffData> newList = new ArrayList<>();
    public static List<String> getData = new ArrayList<>();

    public static String[] orderResultSplit;
    public static String[] status = {"Processing", "Delivering", "Delivered"};

    public JButton backButton = new JButton("Back");
    public JButton assignButton = new JButton("Save");

    public static String orderResult1;
    public static String orderResult2;
    public static String staffResult1;
    public static String staffResult2;

    public JComboBox orderList;
    public JComboBox staffL;

    public JPanel rating = new JPanel(new BorderLayout());
    public JPanel comment = new JPanel(new BorderLayout());

    public JTextField ratingT = new JTextField();
    public JTextArea commentT = new JTextArea();

    public JLabel rLabel = new JLabel("Rating:");
    public JLabel cLabel = new JLabel("Comment:");

    public updateStatus() {

        getOrders();

        String[] list = new String[getOrderData.size()];

        for (int i = 0; i < getOrderData.size(); i++) {
            list[i] = getOrderData.get(i);
        }


        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centPanel = new JPanel(new BorderLayout());
        JPanel bottPanel = new JPanel(new BorderLayout());
        JPanel bottPanel1 = new JPanel(new BorderLayout());
        JPanel bottPanel2 = new JPanel(new BorderLayout());

        JLabel orderLabel = new JLabel("Select Orders:");
        JLabel staffLabel = new JLabel("Status:");


        orderList = new JComboBox(list);
        staffL = new JComboBox(status);
        orderList.addItemListener(this);
        staffL.addItemListener(this);

        assignButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String s = orderList.getSelectedItem().toString();
                orderResultSplit = s.split("/");
                System.out.println("OK" + orderResultSplit[0]);

                orderResult1 = orderResultSplit[0];
                orderResult2 = orderResultSplit[1];

                update();

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton.removeActionListener(this);
                orderList.removeActionListener(this);
                staffL.removeActionListener(this);
                frame.dispose();
                new Delivery();
            }
        });

        topPanel.add(orderList, BorderLayout.PAGE_END);
        topPanel.add(orderLabel, BorderLayout.PAGE_START);

        centPanel.add(staffL, BorderLayout.PAGE_END);
        centPanel.add(staffLabel, BorderLayout.PAGE_START);
        bottPanel1.add(assignButton);
        bottPanel2.add(backButton);

        bottPanel.add(bottPanel1, BorderLayout.LINE_END);
        bottPanel.add(bottPanel2, BorderLayout.LINE_START);

        topPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        centPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        rating.setBorder(BorderFactory.createEmptyBorder(35,20,35,20));
        comment.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        bottPanel.setBorder(BorderFactory.createEmptyBorder(70,20,20,20));

        rating.setVisible(false);
        comment.setVisible(false);

        panel.add(topPanel);
        panel.add(centPanel);
        panel.add(rating);
        panel.add(comment);
        panel.add(bottPanel);

        rating.add(rLabel, BorderLayout.PAGE_START);
        rating.add(ratingT, BorderLayout.CENTER);
        comment.add(cLabel, BorderLayout.PAGE_START);
        comment.add(commentT, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 600);
        frame.setTitle("Assign Orders");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void getOrders() {

        newOrderList.clear();

        System.out.println(Login.currentUser);

        String[] split = Login.currentUser.split("/");
        System.out.println(split[2]);

        String currId = split[0];


        int i = 0;

        String tempString;

        try {

            File file = new File("customer.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();
                if (tempString.contains(currId)) {

                    orderFull.add(tempString);
                    orderSplit = tempString.split("/"); //splits line
                    pendingData sL = new pendingData(orderSplit[0], orderSplit[1], orderSplit[2]);
                    newOrderList.add(sL);
                    System.out.println(orderFull);
                    s.nextLine();
                }

            }

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (i < newOrderList.size()) {

            pendingData sD = newOrderList.get(i);
            String data = sD.getOrderId() + "/" + sD.getName();
            getOrderData.add(data);
            System.out.println(data);
            i++;
        }

    }

    public void update() {

        String[] split = Login.currentUser.split("/");

        String[] selOrder = orderList.getSelectedItem().toString().split("/");
        System.out.println(split[2]);

        String currId = split[0];

        String tempString = null;


        try {

            int index = 0;


            File file = new File("feedback.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(selOrder[0] + "/" + split[0] + "/" + selOrder[1] + "/" + ratingT.getText() + "/" + commentT.getText() + "\n");

            s.close();
            writer.close();

            System.out.println("Success");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (staffL.getSelectedItem() == "Delivered") {

            rating.setVisible(true);
            comment.setVisible(true);

        }

        else {
            rating.setVisible(false);
            comment.setVisible(false);
        }

    }
}

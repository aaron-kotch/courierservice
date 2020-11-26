package Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class assignOrders implements ItemListener {

    public static ArrayList<String> orderFull = new ArrayList<>();
    public static String[] orderSplit;
    public static ArrayList<customerData> newOrderList = new ArrayList<>();
    public static List<String> getOrderData = new ArrayList<>();

    public static ArrayList<String> staffFull = new ArrayList<>();
    public static String[] staffSplit;
    public static ArrayList<staffData> newList = new ArrayList<>();
    public static List<String> getData = new ArrayList<>();

    public assignOrders() {

        getOrders();
        getStaff();

        String[] list = new String[getOrderData.size()];
        String[] staffList = new String[getData.size()];

        for (int i = 0; i < getOrderData.size(); i++) {
            list[i] = getOrderData.get(i);
        }

        for (int i = 0; i < getData.size(); i++) {
            staffList[i] = getData.get(i);
        }

        System.out.println("Data: " + getData);

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centPanel = new JPanel(new BorderLayout());
        JPanel bottPanel = new JPanel(new BorderLayout());
        JButton assignButton = new JButton("Save");

        JLabel orderLabel = new JLabel("Select Orders:");
        JLabel staffLabel = new JLabel("Assign to:");


        JComboBox orderList = new JComboBox(list);
        JComboBox staffL = new JComboBox(staffList);
        orderList.addItemListener(this);
        staffL.addItemListener(this);

        topPanel.add(orderList, BorderLayout.PAGE_END);
        topPanel.add(orderLabel, BorderLayout.PAGE_START);

        centPanel.add(staffL, BorderLayout.PAGE_END);
        centPanel.add(staffLabel, BorderLayout.PAGE_START)
;        bottPanel.add(assignButton);

        topPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        centPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        bottPanel.setBorder(BorderFactory.createEmptyBorder(40,20,20,20));

        panel.add(topPanel);
        panel.add(centPanel);
        panel.add(bottPanel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setTitle("Assign Orders");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new assignOrders();
    }

    public void getOrders() {

        newOrderList.clear();

        int i = 0;

        String tempString;

        try {

            File file = new File("CustomerDetails.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();
                if (tempString.contains("assigned")) {
                    orderFull.add(tempString);
                    orderSplit = tempString.split("/"); //splits line
                    customerData sL = new customerData(orderSplit[0], orderSplit[1], orderSplit[2], orderSplit[3], orderSplit[4], orderSplit[5], orderSplit[6], orderSplit[7]);
                    newOrderList.add(sL);
                    System.out.println(orderFull);
                }
                s.nextLine();
            }

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (i < newOrderList.size()) {

            customerData sD = newOrderList.get(i);
            String data = sD.getId() + " | " + sD.getName();
            getOrderData.add(data);
            System.out.println(data);
            i++;
        }

    }

    public void getStaff() {

        newList.clear();

        int i = 0;

        String tempString;

        try {

            File file = new File("staffDetails.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                tempString = s.next();
                if (tempString.contains("Available")) {
                    staffFull.add(tempString);
                    staffSplit = tempString.split("/"); //splits line
                    staffData sL = new staffData(staffSplit[0], staffSplit[1], staffSplit[2], staffSplit[3], staffSplit[4], staffSplit[5], staffSplit[6], staffSplit[7]);
                    newList.add(sL);
                    System.out.println(staffFull);
                }
                s.nextLine();
            }

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (i < newList.size()) {

            staffData sD = newList.get(i);
            String data = sD.getId() + " | " + sD.getName();
            getData.add(data);
            System.out.println(data);
            i++;

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}

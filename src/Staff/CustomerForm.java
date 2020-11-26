package Staff;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class CustomerForm extends JFrame implements ActionListener{

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField cusName;
    private JLabel phoneNumLabel;
    private JTextField phoneNum;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1985","1986","1987","1988","1989",
            "1990","1991","1992","1993","1994",
            "1995", "1996", "1997", "1998", "1999",
            "2000", "2001", "2002", "2003", "2004",
            "2005", "2006", "2007", "2008", "2009",
            "2010", "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018", "2019",
            "2020", "2021", "2022", "2023", "2024",
            "2025", "2026", "2027", "2028", "2029",
            "2030", "2031", "2032", "2033", "2034"};

    // constructor, to initialize the components
    // with default values.
    public CustomerForm()
    {
        setTitle("Customer Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Customer Details Form");
        title.setFont(new Font("OCR A Std", Font.PLAIN, 30));
        title.setSize(500, 40);
        title.setLocation(230, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Serif", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        cusName = new JTextField();
        cusName.setFont(new Font("Serif", Font.PLAIN, 15));
        cusName.setSize(190, 20);
        cusName.setLocation(200, 100);
        c.add(cusName);

        phoneNumLabel = new JLabel("Phone No: ");
        phoneNumLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        phoneNumLabel.setSize(100, 20);
        phoneNumLabel.setLocation(100, 150);
        c.add(phoneNumLabel);

        phoneNum = new JTextField();
        phoneNum.setFont(new Font("Serif", Font.PLAIN, 15));
        phoneNum.setSize(150, 20);
        phoneNum.setLocation(200, 150);
        c.add(phoneNum);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Serif", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Serif", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Serif", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("Order Date");
        dob.setFont(new Font("Serif", Font.PLAIN, 20));
        dob.setSize(300, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Serif", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(230, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Serif", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(280, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Serif", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(350, 250);
        c.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Serif", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Serif", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);


        sub = new JButton("Submit");
        sub.setFont(new Font("Serif", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Serif", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Serif", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Serif", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Serif", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {

            String data1;
            String data = "Name : "+ cusName.getText() + "\n"+ "Mobile : "+ phoneNum.getText() + "\n";
            if (male.isSelected())
                data1 = "Gender: Male \n";
            else
                data1 = "Gender: Female \n";
            String data2
                    = "DOB : "
                    + (String)date.getSelectedItem()
                    + "/" + (String)month.getSelectedItem()
                    + "/" + (String)year.getSelectedItem()
                    + "\n";

            String data3 = "Address : " + tadd.getText();
            tout.setText(data + data1 + data2 + data3);
            tout.setEditable(false);
            res.setText("Order added Successfully.");


            //WRITING
            //create customer obj using form n store in array
            //String name, String mobileNum, String gender, String address

            Enumeration buttonPointer = gengp.getElements();
            JRadioButton genderRb = null;

            while(buttonPointer.hasMoreElements()){
                genderRb = (JRadioButton) buttonPointer.nextElement();

                if(genderRb.isSelected()){
                    System.out.println(genderRb.getText());
                    break;
                }
            }

            Customer cust = new Customer(cusName.getText(), phoneNum.getText(), genderRb.getText(), data3);
            Customer.allCustomers.add(cust);
            System.out.println(Customer.allCustomers.size());
            System.out.println("CUSTOMER SAVED");

            PrintWriter w;
            try {
                w = new PrintWriter("CustomerDetails.txt");
                for(int i=0; i<Customer.allCustomers.size(); i++){ //
                    w.println(Customer.allCustomers.get(i).getName());
                    w.println(Customer.allCustomers.get(i).getphoneNum());
                    w.println(Customer.allCustomers.get(i).getGender());
                    w.println(Customer.allCustomers.get(i).getAddress());
                    w.println();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }



            //READING --at logout - save all data
//                try{
//                    createFile(new File("CustomerDetails"));
//                    Scanner s = new Scanner(new File("CustomerDetails.txt"));
//                    while(s.hasNext()){
//                        String name = s.nextLine();
//                        int mobile = Integer.parseInt(s.nextLine());
//                        String address = s.nextLine();
//
//                        s.nextLine(); // reads the empty line
//
//                        //Customer cust = new Customer(name, mobile, address);
//                        //Add to array
//                    }
//                }
//                catch(IOException ex){
//                    System.out.println("Error");
//                }


        }

        else if (e.getSource() == reset) {
            String def = "";
            cusName.setText(def);
            tadd.setText(def);
            phoneNum.setText(def);
            res.setText(def);
            tout.setText(def);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        }
    }

    //please rework this or gei
    public static void createFile(File file){
        try{
            if (file.createNewFile()) {
                System.out.println("Success: File created: " + file.getName());
            }
            else {
                System.out.println(file.getName() + " File already exists");
            }
        }
        catch(IOException e){
            System.out.println("FAILED TO CREATE FILE via createFile(): " + e + ":(");
        }
    }



}

package Staff;

import java.util.ArrayList;


public class Customer extends Personnel{

    public static ArrayList<Customer> allCustomers = new ArrayList();

    //constructors
    public Customer(String name, String phoneNum, String gender, String orderDate, String address){
        super(name, phoneNum, gender, orderDate, address);
    }
}
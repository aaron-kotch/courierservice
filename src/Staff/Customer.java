package Staff;

import java.util.ArrayList;

public class Customer extends Personnel {

    public static ArrayList<Customer> allCustomers = new ArrayList();

    public Customer(String name, String phone, String gender, String date, String address){
        super(name, phone, gender, date, address);
    }

    public Customer(String id, String name, String phone, String gender, String date, String address, String payment, String status) {



        super(id, name, phone, gender, date, address, payment, status);


    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String getAdd() {
        return address;
    }

    public String getPay() {
        return payment;
    }

    public String getStatus() {
        return status;
    }
}


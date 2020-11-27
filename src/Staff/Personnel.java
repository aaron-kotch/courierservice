package Staff;


public class Personnel {
    //protected for use in subclass
    //private cant use in subclass
    protected String id;
    protected String name;
    protected String phone;
    protected String gender;
    protected String date;
    protected String address;
    protected String payment;
    protected String status;

    public Personnel(String name, String phoneNum, String gender, String orderDate, String address){
        this.name = name;
        this.phone = phoneNum;
        this.gender = gender;
        this.date = orderDate;
        this.address = address;
    }


    public Personnel(String id, String name, String phone, String gender, String date, String address, String payment, String status) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.payment = payment;
        this.status = status;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphoneNum() {
        return phone;
    }

    public void setphoneNum(String phoneNum) {
        this.phone = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrderDate() {
        return date;
    }

    public void setOrderDate(String orderDate) {
        this.date = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
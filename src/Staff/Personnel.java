package Staff;


public class Personnel {
    //protected for use in subclass
    //private cant use in subclass
    protected String name;
    protected String phoneNum;
    protected String gender;
    protected String address;

    public Personnel(String name, String phoneNum, String gender, String address){
        this.name = name;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphoneNum() {
        return phoneNum;
    }

    public void setphoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package Staff;

public class customerData {

    public final String id;
    public final String name;
    public final String phone;
    public final String gender;
    public final String date;
    public final String address;
    public final String payment;
    public final String status;

    public customerData(String id, String name, String phone, String gender, String date, String address, String payment, String status) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.payment = payment;
        this.status = status;

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


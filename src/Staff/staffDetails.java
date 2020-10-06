package Staff;


public class staffDetails {

    private String name;
    private String email;
    private String password;
    private String contactNum;

    public staffDetails(String staffName, String staffEmail, String staffPassword, String staffContactNum) {

        name = staffName;
        email = staffEmail;
        password = staffPassword;
        contactNum = staffContactNum;

    }

    public void displayDetails() {

        System.out.println("Welcome " + name);
    }






    
}

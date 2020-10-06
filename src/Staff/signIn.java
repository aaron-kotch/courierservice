package Staff;

import java.util.Scanner;

public class signIn {

    private boolean signedIn;

    private static String name;
    private static String email;
    private static String password;
    private static String contact;

    public static void logIn() {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter name: ");
        name = s.nextLine();

        System.out.println("Enter email: ");
        email = s.nextLine();

        System.out.println("Enter password: ");
        password = s.nextLine();

        System.out.println("Enter contact number: ");
        contact = s.nextLine();

    }

    public void enterDetails() {

        System.out.println(name + email + password + contact);

    }



}

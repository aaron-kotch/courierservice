package Staff;

public class staffData {

    public final String name;
    public final String phone;
    public final String id;
    public final String email;
    public final String role;
    public final String username;
    public final String password;

    public staffData(String name, String phone, String id, String email, String role, String username, String password) {

        this.name = name;
        this.phone = phone;
        this.id = id;
        this.email = email;
        this.role = role;
        this.username = username;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


package Staff;
import java.util.ArrayList;

public class Staff {

    private final String name;
    private final String password;

    public Staff(String name, String password) {

        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}

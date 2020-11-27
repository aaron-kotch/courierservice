package Staff;

public class pendingData {

    public final String orderId;
    public final String staffId;
    public final String name;


    public pendingData(String orderId, String staffId, String name) {

        this.orderId = orderId;
        this.staffId = staffId;
        this.name = name;

    }

    public String getOrderId() {
        return orderId;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }


}
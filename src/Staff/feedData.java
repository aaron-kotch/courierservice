package Staff;

public class feedData {

    public final String orderId;
    public final String staffId;
    public final String name;
    public final String rating;
    public final String comment;

    public feedData(String orderId, String staffId, String name, String rating, String comment) {

        this.orderId = orderId;
        this.staffId = staffId;
        this.name = name;
        this.rating = rating;
        this.comment = comment;

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

    public String getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
package fos.fos.pojo;


public class PlaceOrderResponse {
    private String orderId;
    private String message;
    private String assignedRestaurant;

    public PlaceOrderResponse(String orderId, String message, String assignedRestaurant) {
        this.orderId = orderId;
        this.message = message;
        this.assignedRestaurant = assignedRestaurant;
    }

    public PlaceOrderResponse() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAssignedRestaurant() {
        return assignedRestaurant;
    }

    public void setAssignedRestaurant(String assignedRestaurant) {
        this.assignedRestaurant = assignedRestaurant;
    }
}

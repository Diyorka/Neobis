package part2;


public class Order {
    private int id;
    private int laptopId;
    private int buyerId;
    private String orderDate;

    public Order() {
    }

    public Order(int id, int laptopId, int buyerId, String orderDate) {
        this.id = id;
        this.laptopId = laptopId;
        this.buyerId = buyerId;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", laptopId=" + laptopId +
                ", buyerId=" + buyerId +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}

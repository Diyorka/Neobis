package part2;


public class Order {
    private int id;
    private Laptop laptop;
    private int laptopCount;
    private Buyer buyer;
    private String orderDate;

    public Order() {
    }

    public Order(int id, Laptop laptop, int laptopCount, Buyer buyer, String orderDate) {
        this.id = id;
        this.laptop = laptop;
        this.laptopCount = laptopCount;
        this.buyer = buyer;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getLaptopCount() {
        return laptopCount;
    }

    public void setLaptopCount(int laptopCount) {
        this.laptopCount = laptopCount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
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
                ", laptop=" + laptop +
                ", laptopCount=" + laptopCount +
                ", buyer=" + buyer +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}

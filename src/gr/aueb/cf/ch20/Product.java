package gr.aueb.cf.ch20;

public class Product {
    private long id;
    private String title;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(long id, String title, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void getProduct() {
        System.out.println("ID: "+id+", Title: "+title+", Price: "+price+", Quantity:"+quantity);
    }

    public static void pullProduct(Product product) {
        System.out.printf("ID: %d, Item: %s, Price: %.2f, Quantity: %d\n",
                product.getId(),product.getTitle(),product.getPrice(),product.getQuantity());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

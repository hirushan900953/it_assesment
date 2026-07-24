/**
 * Product.java
 * ----------------------------------------
 * Represents a single product in the Inventory Management System.
 * This class stores product details and provides methods
 * to access, modify, and display product information.
 */

public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;

    /**
     * Default constructor.
     */
    public Product() {
    }

    /**
     * Parameterized constructor.
     *
     * @param productId Unique product ID
     * @param productName Name of the product
     * @param category Product category
     * @param price Unit price
     * @param quantity Available quantity
     */
    public Product(int productId, String productName, String category,
                   double price, int quantity) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Updates the product price.
     * Only positive values are accepted.
     */
    public void setPrice(double price) {

        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Updates the available stock.
     */
    public void setQuantity(int quantity) {

        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    /**
     * Calculates the total value of this product.
     *
     * @return Total product value
     */
    public double calculateValue() {
        return price * quantity;
    }

    /**
     * Returns the stock status.
     */
    public String getStockStatus() {

        if (quantity <= 5) {
            return "Low Stock";
        } else if (quantity <= 20) {
            return "Medium Stock";
        } else {
            return "In Stock";
        }
    }

    /**
     * Displays product details in a table format.
     */
    public void displayProduct() {

        System.out.printf("%-8d %-20s %-15s %-10.2f %-10d %-15s%n",
                productId,
                productName,
                category,
                price,
                quantity,
                getStockStatus());
    }

    @Override
    public String toString() {

        return "Product{" +
                "ID=" + productId +
                ", Name='" + productName + '\'' +
                ", Category='" + category + '\'' +
                ", Price=" + price +
                ", Quantity=" + quantity +
                '}';
    }
}
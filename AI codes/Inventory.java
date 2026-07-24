import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> products = new ArrayList<>();

    /**
     * Adds a new product after checking for duplicate IDs.
     */
    public boolean addProduct(Product product) {

        if (findProductById(product.getProductId()) != null) {
            System.out.println("Product ID already exists.");
            return false;
        }

        products.add(product);
        System.out.println("Product added successfully.");
        return true;
    }

    /**
     * Displays all products.
     */
    public void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Category", "Price", "Quantity", "Status");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (Product product : products) {
            product.displayProduct();
        }

        System.out.println("------------------------------------------------------------------------------------------------");
    }

    /**
     * Finds a product using its ID.
     */
    public Product findProductById(int id) {

        for (Product product : products) {

            if (product.getProductId() == id) {
                return product;
            }
        }

        return null;
    }

    /**
     * Finds a product using its name.
     */
    public Product findProductByName(String name) {

        for (Product product : products) {

            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    /**
     * Displays a searched product.
     */
    public void searchProduct(int id) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("\nSearch Result");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Category", "Price", "Quantity", "Status");
        System.out.println("---------------------------------------------------------------");

        product.displayProduct();
    }

    /**
     * Updates product information.
     */
    public boolean updateProduct(int id,
                                 String name,
                                 String category,
                                 double price,
                                 int quantity) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        product.setProductName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setQuantity(quantity);

        System.out.println("Product updated successfully.");
        return true;
    }

    /**
     * Deletes a product.
     */
    public boolean deleteProduct(int id) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        products.remove(product);

        System.out.println("Product deleted successfully.");
        return true;
    }

    /**
     * Updates only the stock quantity.
     */
    public boolean updateStock(int id, int quantity) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        product.setQuantity(quantity);

        System.out.println("Stock updated successfully.");
        return true;
    }

    /**
     * Displays products with low stock.
     */
    public void showLowStockProducts() {

        boolean found = false;

        System.out.println("\nLow Stock Products");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Category", "Price", "Quantity", "Status");
        System.out.println("---------------------------------------------------------------");

        for (Product product : products) {

            if (product.getQuantity() <= 5) {

                product.displayProduct();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low stock products found.");
        }
    }

    /**
     * Calculates the total inventory value.
     */
    public double calculateInventoryValue() {

        double total = 0;

        for (Product product : products) {
            total += product.calculateValue();
        }

        return total;
    }

    /**
     * Displays inventory statistics.
     */
    public void displayInventorySummary() {

        int totalProducts = products.size();
        int totalQuantity = 0;

        for (Product product : products) {
            totalQuantity += product.getQuantity();
        }

        System.out.println("\n================ Inventory Summary ================");
        System.out.println("Total Products      : " + totalProducts);
        System.out.println("Total Stock Units   : " + totalQuantity);
        System.out.printf("Inventory Value     : Rs. %.2f%n", calculateInventoryValue());
        System.out.println("==================================================");
    }

    /**
     * Returns true if inventory has no products.
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }
}
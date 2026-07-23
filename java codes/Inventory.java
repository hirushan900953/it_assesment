import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getProductId() == product.getProductId()) {
                System.out.println("Product ID already exists.");
                return;
            }
        }

        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    public Product searchProduct(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    public void updateProduct(int id, String name, String category, double price) {
        Product p = searchProduct(id);

        if (p != null) {
            p.setProductName(name);
            p.setCategory(category);
            p.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        Product p = searchProduct(id);

        if (p != null) {
            products.remove(p);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void updateStock(int id, int quantity) {
        Product p = searchProduct(id);

        if (p != null) {
            p.setQuantity(quantity);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void lowStockReport() {
        boolean found = false;

        for (Product p : products) {
            if (p.getQuantity() < 10) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low stock products.");
        }
    }

    public void calculateInventoryValue() {
        double total = 0;

        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }

        System.out.println("Total Inventory Value: " + total);
    }
}
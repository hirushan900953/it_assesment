import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Update Stock");
            System.out.println("7. Low Stock Report");
            System.out.println("8. Calculate Inventory Value");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    Product product = new Product(id, name, category, price, quantity);
                    inventory.addProduct(product);
                    break;

                case 2:
                    inventory.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID to search: ");
                    Product found = inventory.searchProduct(sc.nextInt());

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    inventory.updateProduct(updateId, newName, newCategory, newPrice);
                    break;

                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    inventory.deleteProduct(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Product ID: ");
                    int stockId = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    inventory.updateStock(stockId, newQty);
                    break;

                case 7:
                    inventory.lowStockReport();
                    break;

                case 8:
                    inventory.calculateInventoryValue();
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
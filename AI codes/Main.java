import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;

        do {

            System.out.println("\n=================================================");
            System.out.println("        INVENTORY MANAGEMENT SYSTEM");
            System.out.println("=================================================");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product");
            System.out.println("7. Update Stock");
            System.out.println("8. Low Stock Report");
            System.out.println("9. Inventory Summary");
            System.out.println("10. Calculate Inventory Value");
            System.out.println("11. Exit");
            System.out.println("=================================================");
            System.out.print("Enter your choice: ");

            try {

                choice = input.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Product ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = input.nextLine();

                        System.out.print("Enter Category: ");
                        String category = input.nextLine();

                        double price;

                        while (true) {
                            System.out.print("Enter Price: ");
                            price = input.nextDouble();

                            if (price >= 0)
                                break;

                            System.out.println("Price cannot be negative.");
                        }

                        int quantity;

                        while (true) {
                            System.out.print("Enter Quantity: ");
                            quantity = input.nextInt();

                            if (quantity >= 0)
                                break;

                            System.out.println("Quantity cannot be negative.");
                        }

                        Product product = new Product(id, name, category, price, quantity);

                        inventory.addProduct(product);
                        break;

                    case 2:

                        inventory.viewProducts();
                        break;

                    case 3:

                        System.out.print("Enter Product ID: ");
                        int searchId = input.nextInt();

                        inventory.searchProduct(searchId);

                        break;

                    case 4:

                        input.nextLine();

                        System.out.print("Enter Product Name: ");
                        String searchName = input.nextLine();

                        Product found = inventory.findProductByName(searchName);

                        if (found != null) {

                            System.out.println("\n---------------------------------------------------------------");
                            System.out.printf("%-8s %-20s %-15s %-10s %-10s %-15s%n",
                                    "ID", "Name", "Category", "Price", "Quantity", "Status");
                            System.out.println("---------------------------------------------------------------");

                            found.displayProduct();

                        } else {

                            System.out.println("Product not found.");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Product ID: ");
                        int updateId = input.nextInt();
                        input.nextLine();

                        System.out.print("New Product Name: ");
                        String newName = input.nextLine();

                        System.out.print("New Category: ");
                        String newCategory = input.nextLine();

                        System.out.print("New Price: ");
                        double newPrice = input.nextDouble();

                        System.out.print("New Quantity: ");
                        int newQuantity = input.nextInt();

                        inventory.updateProduct(updateId,
                                newName,
                                newCategory,
                                newPrice,
                                newQuantity);

                        break;

                    case 6:

                        System.out.print("Enter Product ID: ");
                        int deleteId = input.nextInt();

                        inventory.deleteProduct(deleteId);

                        break;

                    case 7:

                        System.out.print("Enter Product ID: ");
                        int stockId = input.nextInt();

                        System.out.print("Enter New Quantity: ");
                        int stock = input.nextInt();

                        inventory.updateStock(stockId, stock);

                        break;

                    case 8:

                        inventory.showLowStockProducts();

                        break;

                    case 9:

                        inventory.displayInventorySummary();

                        break;

                    case 10:

                        System.out.printf("\nTotal Inventory Value : Rs. %.2f%n",
                                inventory.calculateInventoryValue());

                        break;

                    case 11:

                        System.out.println("\nThank you for using the Inventory Management System.");
                        System.out.println("Program terminated successfully.");

                        break;

                    default:

                        System.out.println("Invalid menu option.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter the correct data type.");
                input.nextLine();
                choice = 0;

            }

        } while (choice != 11);

        input.close();
    }
}

import java.util.Scanner;

public class FoodDelivery2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the QueensPlaza!");
        System.out.println("--------------------------------------");

        System.out.print(" enter your name: ");
        String name = scanner.nextLine();

        System.out.print(" enter your address: ");
        String address = scanner.nextLine();

        System.out.print(" enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.length() != 10) {
            System.out.println("Invalid number. Phone number must be 10 digits.");
            System.exit(1);
        }

        // Initialize variables for the order summary
        double subtotal = 0.0;
        int totalItems = 0;
        String orderDetails = "";
        System.out.println("\n--- Let's build your order ---");

        char continueOrdering = 'y';
        while (continueOrdering == 'y' || continueOrdering == 'Y') {
            System.out.print("\nEnter the name of the food item: ");
            String foodItem = scanner.nextLine();

            System.out.print("Enter the quantity of " + foodItem + ": ");
            int quantity = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter the price per item for " + foodItem + ": ₹");
            double pricePerItem = scanner.nextDouble();

            scanner.nextLine(); // Consume the newline character

            double itemCost = quantity * pricePerItem;
            subtotal += itemCost;
            totalItems += quantity;

            // Format the details for the order summary string
            orderDetails += String.format("- %d x %s (₹%.2f each) = ₹%.2f\n", quantity, foodItem, pricePerItem, itemCost);

            System.out.print("\nAdd another item? (y/n): ");
            continueOrdering = scanner.nextLine().charAt(0);
        }

        // Using a common GST rate for food in India (5%)
        double GST_RATE = 0.05;

        double gst = subtotal * GST_RATE;

        double grandTotal = subtotal + gst;

        System.out.println("\n\n--------------------------------------");
        System.out.println("           ORDER SUMMARY           ");
        System.out.println("--------------------------------------");
        System.out.println("Customer Name: " + name);
        System.out.println("Delivery Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Total Items: " + totalItems);
        System.out.println("--------------------------------------");
        System.out.println("Your Items:\n" + orderDetails);
        System.out.println("--------------------------------------");
        System.out.println(String.format("Subtotal:            ₹%.2f", subtotal));
        System.out.println(String.format("GST (%.0f%%):          ₹%.2f", GST_RATE * 100, gst));
        System.out.println("--------------------------------------");
        System.out.println(String.format("GRAND TOTAL:         ₹%.2f", grandTotal));
        System.out.println("--------------------------------------");
        System.out.println("\nThank you, " + name + ", for your order! It will be delivered to " + address + ".");

        scanner.close();
    }
}
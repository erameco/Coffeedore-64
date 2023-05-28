import java.util.ArrayList;
import java.util.Scanner;
class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        newItem.setIndex(menu.size());
        menu.add(newItem);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Cafe Java! Here's our menu:");
        displayMenu();

       String input;
        do {
            System.out.println("To place an order, enter the item index or 'q' to quit:");
            input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Order canceled. Goodbye!");
                
                break;
            }

            try {
                int itemIndex = Integer.parseInt(input); //is used to convert the user's input, which is a string representing the item index, into an integer value.

                if (itemIndex >= 0 && itemIndex < menu.size()) {
                    Item selectedItem = menu.get(itemIndex);

                    Order newOrder = new Order(selectedItem);
                    orders.add(newOrder);

                    System.out.println("Added " + selectedItem.getName() + " to your order.");
                } else {
                    System.out.println("Invalid item index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item index or 'q' to quit.");
            }
        } while (true);

    }

    public void displayOrderDetails() {
        System.out.println("Order details:");
        double totalPrice = 0.0;

        for (Order order : orders) {
            Item item = order.getItem();
            System.out.println(item.getName() + " -- $" + item.getPrice());
            totalPrice += item.getPrice();
        }

        System.out.println("Total: $" + totalPrice);
    }
}

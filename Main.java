import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            CoffeeKiosk coffeeKiosk = new CoffeeKiosk();
            System.out.println("Please enter customer name for new order:");
            String name = System.console().readLine();

            coffeeKiosk.addMenuItem("banana", 2.00);
            coffeeKiosk.addMenuItem("coffee", 1.50);
            coffeeKiosk.addMenuItem("latte", 4.50);
            coffeeKiosk.addMenuItem("cappuccino", 3.00);
            coffeeKiosk.addMenuItem("muffin", 4.00);
    
            coffeeKiosk.newOrder();
            coffeeKiosk.displayOrderDetails();
        }
    }
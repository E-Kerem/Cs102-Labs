import java.util.Scanner;

/**
 * @author Efe Kerem Kesgin
 * @version 05/10/2020
 */
public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntBag bag = new IntBag();
        int input;
        do {
            System.out.println("\nChoose an option : ");
            System.out.println("1.Create a new empty collection ");
            System.out.println("2.Read a set of positive values into the collection ");
            System.out.println("3.Print the collection of values ");
            System.out.println("4.Add a value to the collection of values at a specified location ");
            System.out.println("5.Remove the value at a specified location from the collection of values ");
            System.out.println("6.Remove all instances of a value within the collection ");
            System.out.println("7. Quit the program ");
            input = scan.nextInt();
            if (input == 1) {
                bag = new IntBag();
            } else if (input == 2) {
                int value;
                do {
                    value = scan.nextInt();
                    if (value == 0) {
                        break;
                    }
                    bag.add(value);
                } while (value != 0);
            } else if (input == 3) {
                for (int i = 0; i < bag.getBag().length; i++) {
                    System.out.print(" " + bag.getBag()[i]);
                }
            } else if (input == 4) {
                System.out.println("Enter the number you want to add and the index...");
                int num = scan.nextInt();
                int index = scan.nextInt();
                bag.add(num, index);
            } else if (input == 5) {
                System.out.println("Enter the index you want to remove...");
                int index = scan.nextInt();
                bag.remove(index);
            } else if (input == 6) {
                System.out.println("Enter the number you want to remove from collection...");
                int num = scan.nextInt();
                bag.removeAll(num);
            }
        } while (input >= 1 && input < 7);
    }
}

import javax.swing.*;
import java.util.Scanner;

public class Potluck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        JFrame frame= new JFrame("Button Matrix Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("Please insert the dimension of the pot luck game");
        int n = scan.nextInt();

        frame.getContentPane().add(new PotluckPanel(n));
        frame.pack();
        frame.setVisible(true);
    }
}
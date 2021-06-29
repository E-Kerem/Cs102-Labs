import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman
{
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Start of ConsoleHangman\n");

	// VARIABLES
	HangmanModel hangman;
	ConsoleHangmanView view = new ConsoleHangmanView();
	// PROGRAM CODE
	hangman = new HangmanModel(new Main());
	hangman.addView(view);
	//hangman.addView(new ConsoleHangmanView());
	do {
		char currentLetter = scan.nextLine().charAt(0);
		hangman.tryThis(currentLetter);
	} while (!hangman.isGameOver());
	System.out.println("\nEnd of ConsoleHangman\n");
}
} // end of class ConsoleHangman

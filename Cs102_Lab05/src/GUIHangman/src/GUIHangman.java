import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel			hangman;
		IHangmanSetup			basicSetup;
		ConsoleHangmanView		consoleView;
		TextFieldControlPanel 	textFieldControlPanel;
		NewGameButtonControl	newGameButtonControl;
		LabelsHangmanView		labelsHangmanView;
		GallowsHangmanView		gallowsHangmanView;
		LetterButtonControls	letterButtonControls;
		HangmanLetterButtonControls hangmanLetterButtonControls;


		basicSetup = new BasicSetup();
		hangman = new HangmanModel(basicSetup);
		textFieldControlPanel = new TextFieldControlPanel(hangman);
		newGameButtonControl = new NewGameButtonControl(hangman);
		labelsHangmanView = new LabelsHangmanView();
		gallowsHangmanView = new GallowsHangmanView(hangman);
		letterButtonControls = new LetterButtonControls(hangman.getAllLetters(),13,2);
		hangmanLetterButtonControls = new HangmanLetterButtonControls(hangman,13,2);

		hangmanLetterButtonControls.addActionListener(new HangmanLetterButtonsController(hangman));
		hangman.addView(hangmanLetterButtonControls);
		hangman.addView(newGameButtonControl);
		hangman.addView(labelsHangmanView);
		hangman.addView(gallowsHangmanView);
		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView);

		new SimpleJFrame( "GUIHangman", gallowsHangmanView,textFieldControlPanel,
				newGameButtonControl.button1, hangmanLetterButtonControls, labelsHangmanView );

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman

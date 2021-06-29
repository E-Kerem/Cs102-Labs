import cs102.Hangman;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;

public class LabelsHangmanView extends JPanel implements IHangmanView {
    //properties
    JLabel tries;
    JLabel usedWords;
    JLabel secretWord;
    JPanel holder;

    //constants
    private static final Font font = new Font("Times New Roman", Font.BOLD, 50);

    //constructor
    public LabelsHangmanView() {
        super();
        this.setPreferredSize(new Dimension(400, 200));

        //intializing properties
        tries = new JLabel("");
        usedWords = new JLabel("");
        secretWord = new JLabel("");
        holder = new JPanel();

        //Styling the lables
        tries.setFont(font);
        usedWords.setFont(font);
        secretWord.setFont(font);

        //setting layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(secretWord);
        this.add(tries);
        this.add(usedWords);

        this.setBackground(Color.green);

        //setting layout
    }

    //implementing IHangmanView
    public void updateView(Hangman hangman) {
        //if we're playing the game, these messages are displayed on the panel
        if (!hangman.isGameOver()) {
            secretWord.setText(hangman.getKnownSoFar()); //the secret word
            tries.setText("Tries: " + hangman.getNumOfIncorrectTries()); //number of tries
            usedWords.setText("Used letters: " + hangman.getUsedLetters()); //used letters
        }
        //if the game is over, these messages are displayed on the panel
        else {
            //if the user looses
            if (hangman.hasLost()) {
                //Lost message
                secretWord.setText("Oops");
                tries.setText("You lost!");
                usedWords.setText("You used: " + hangman.getUsedLetters());
            }
            //if the user wins
            else {
                //win message
                secretWord.setText("Congratulations. You won!!!");
                tries.setText("In " + hangman.getNumOfIncorrectTries() + " tries!!");
                usedWords.setText("You used: " + hangman.getUsedLetters());
            }
        }
    }
}

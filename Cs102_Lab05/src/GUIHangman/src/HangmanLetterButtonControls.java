import cs102.Hangman;
import java.awt.*;

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {

    public HangmanLetterButtonControls(Hangman hangman, int rows, int columns) {
        super(hangman.getAllLetters(), rows, columns);
        this.setPreferredSize(new Dimension(300, 250));
    }

    //implementing IHangmanView
    @Override
    public void updateView(Hangman hangman) {
        if (!hangman.getUsedLetters().equals(""))
            this.setDisabled(hangman.getUsedLetters());
        if (hangman.isGameOver())
            setEnabledAll(true);
    }
}

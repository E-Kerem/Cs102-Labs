import cs102.Hangman;

public class ConsoleHangmanView implements IHangmanView {

    @Override
    public void updateView(Hangman hangman) {
        if (!hangman.isGameOver()) {
            System.out.println(hangman.getKnownSoFar());
            System.out.println("You have " + (hangman.getMaxAllowedIncorrectTries()
                    - hangman.getNumOfIncorrectTries()) + " tries left.");
        } else if (hangman.hasLost()) {
            System.out.println("You lost!" );
        } else if (hangman.isGameOver()) {
            System.out.println("You won!");
        }
    }
}

import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonControl extends JButton implements IHangmanView{
    private Hangman hangman;
    JButton button1;

    public NewGameButtonControl( HangmanModel hangman ) {
        this.hangman = hangman;
        ButtonListener buttonListener = new ButtonListener();
        button1 = new JButton("New Game");
        button1.addActionListener(buttonListener);
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        button1.setEnabled(false);
        if (hangmanModel.isGameOver()) {
            button1.setEnabled(true);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hangman.initNewGame();
        }
    }
}

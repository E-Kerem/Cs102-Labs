import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanLetterButtonsController implements ActionListener
{
    //properties
    private HangmanModel hangman;

    //constructor
    public HangmanLetterButtonsController(HangmanModel hangman)
    {
        this.hangman = hangman;
    }

    //implementing ActionListener
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource(); // we first get the source button
        char c = b.getText().charAt(0);// then take its label as a char
        hangman.tryThis(c); //update the Hangman
    }

}
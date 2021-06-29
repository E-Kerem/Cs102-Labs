import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldControlPanel extends JPanel implements ActionListener{
    private Hangman hangman;
    private JTextField textField;

    public TextFieldControlPanel(Hangman hangman) {
        this.hangman = hangman;
        this.textField = new JTextField(30);
        textField.addActionListener(this);
        add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = textField.getText();
        for(int i = 0; i < str.length(); i++ ) {
            hangman.tryThis(str.charAt(i));
        }
        textField.setText("");
    }
}

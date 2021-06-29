import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class GallowsHangmanView extends JPanel implements IHangmanView {
    HangmanModel hangman;

    public GallowsHangmanView(HangmanModel hangman) {
        this.hangman = hangman;
        updateView(hangman);
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //gollows
        g.drawRect(0, 0, 350, 300);
        g.fillRect(10, 250, 250, 30);
        g.fillRect(50, 20, 30, 250);
        g.fillRect(50, 20, 150, 30);
        g.fillRect(170, 50, 10, 30);

        int length = 55;
        int t = hangman.getNumOfIncorrectTries();
        if (t >= 1) {
            g.drawOval(150, 80, 50, 50);
            if (t >= 2) {
                g.drawLine(175, 130, 175, 180);
                if (t >= 3) {
                    g.drawLine(175, 140, 175 + length, 160);
                    if (t >= 4) {
                        g.drawLine(175, 140, 175 - length, 160);
                        if (t >= 5) {
                            g.drawLine(175, 180, 175 + length, 230);
                            if (t >= 6) {
                                g.drawLine(175, 180, 175 - length, 230);
                            }
                        }
                    }
                }
            }
        }

        if (hangman.isGameOver() && !hangman.hasLost()) {
            g.drawString("You win!", 250, 40);
        } else if (hangman.hasLost()) {
            g.drawString("You lost!", 250, 40);
        }
    }

    @Override
    public void updateView(Hangman hangman) {
        repaint();
    }
}

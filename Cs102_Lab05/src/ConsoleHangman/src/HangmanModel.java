import cs102.Hangman;
import cs102.IHangmanSetup;

import java.util.ArrayList;

public class HangmanModel extends Hangman {
    private ArrayList<IHangmanView> iHangmanViews = new ArrayList<IHangmanView>();

    public HangmanModel(IHangmanSetup setup) {
        super(setup);
    }

    public void addView(IHangmanView view) {
        iHangmanViews.add(view);
        view.updateView(this);
    }
    public void update() {
        for ( IHangmanView views: iHangmanViews ){
            views.updateView(this);
        }
    }
    @Override
    public int tryThis(char letter) {
        int tryThis = super.tryThis(letter);
        update();
        return tryThis;
    }

    @Override
    public void initNewGame() {
        System.out.println("-------------------------------- New Game -------------------------------- ");
        super.initNewGame();
        if ( iHangmanViews != null)
            for ( IHangmanView views : iHangmanViews)
                views.updateView( this);
    }
}
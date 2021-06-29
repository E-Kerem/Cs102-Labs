import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PotluckPanel extends JPanel {
    private JPanel buttonPanel,keypadPanel,topPanel;
    private ArrayList<JButton> buttons;
    private JLabel label;
    private int prize,bomb1,bomb2,count;
    private int attemp = 1;

    public PotluckPanel(int n) {
        buttons = new ArrayList<JButton>();
        keypadPanel = new JPanel();
        keypadPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(n,n));

        PointListener listener = new PointListener();

        for(int i = 0; i < n*n; i++ ){
            String tmp = "Pot" + (i + 1);
            buttons.add(new JButton(tmp));
            buttons.get(i).addActionListener(listener);
            buttonPanel.add(buttons.get(i));
        }
        do {
            this.prize = (int) ((Math.random() * ((buttons.size()) - 1)) + 1);
            this.bomb1 = (int) ((Math.random() * ((buttons.size()) - 1)) + 1);
            this.bomb1 = (int) ((Math.random() * ((buttons.size()) - 1)) + 1);
        } while ( prize == bomb1 && prize == bomb2 && bomb1 == bomb2 );
        this.count = 2;
        this.attemp = 0;
        keypadPanel.add(buttonPanel,BorderLayout.CENTER);
        topPanel = new JPanel();
        label = new JLabel("0");
        topPanel.add(label);
        topPanel.setBackground(Color.yellow);
        keypadPanel.add(topPanel,BorderLayout.NORTH);

        add(keypadPanel);
        setPreferredSize(new Dimension(300,200));
        setBackground(Color.GREEN);
    }

    private class PointListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            attemp++;
            if ( e.getSource() == buttons.get(prize) ) {
                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).setEnabled(false);
                }
                label.setText("Hurray!! Prize Found in " + attemp + "tries" );
                return;
            } else if ( e.getSource() == buttons.get(bomb1) || e.getSource() == buttons.get(bomb2) ) {
                if(e.getSource() == buttons.get(bomb1)) {
                    label.setText("Sorry! You are blown up at attemp " + attemp + "!");
                    for (int i = 0; i < buttons.size(); i++) {
                        buttons.get(i).setEnabled(false);
                    }
                } else if (e.getSource() == buttons.get(bomb2))
                    label.setText("Sorry! You are blown up at attemp " + attemp + "!");
                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).setEnabled(false);
                }
            } else {
                label.setText("Attemp: " + attemp + "!");
            }
        }
    }
}

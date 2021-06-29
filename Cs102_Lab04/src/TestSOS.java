import javax.swing.*;

import cs101.sosgame.SOS;

public class TestSOS {
    public static void main(String[] args) {
        SOSGUIPanel sosguiPanel2 = new SOSGUIPanel();
        String player1,player2;

        JOptionPane.showMessageDialog(null,sosguiPanel2.panel1,"Create your board",JOptionPane.PLAIN_MESSAGE);
        player1 = JOptionPane.showInputDialog("Please enter first player's name: ");
        player2 = JOptionPane.showInputDialog("Please enter second player's name: ");

        JFrame frame = new JFrame ("SOS Game!!");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        SOS sos =new SOS(sosguiPanel2.dimenson);
        SOSGUIPanel canvas = new SOSGUIPanel(sos, player1, player2);

        frame.getContentPane().add (canvas);
        frame.pack();
        frame.setVisible(true);
    }
}
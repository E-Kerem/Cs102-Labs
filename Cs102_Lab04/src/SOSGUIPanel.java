import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;
import java.awt.event.*;

public class SOSGUIPanel extends JPanel{
    Color myColor = new Color(0,100,200);
    JPanel scorePanel;
    SOSCanvas canvas;
    JRadioButton s;
    JRadioButton o;
    String player1;
    String player2;
    JLabel p1;
    JLabel p2;
    SOS game;

    public JPanel panel1,panel2,optionPanel;
    private JButton button1,button2;
    private JTextField textField;
    private JComboBox comboBox;
    private JLabel label;
    public int dimenson;

    public SOSGUIPanel() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        label = new JLabel("Board Size");
        panel1.setLayout(new BorderLayout());
        comboBox = new JComboBox();
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");
        button1 = new JButton("Cancel");
        button2 = new JButton("OK");
        ButtonListener listener = new ButtonListener();
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        panel1.add(label,BorderLayout.NORTH);
        panel2.add(button1);
        panel2.add(button2);
        panel1.add(panel2,BorderLayout.SOUTH);
        panel1.add(comboBox,BorderLayout.CENTER);
    }


    public SOSGUIPanel(SOS game, String player1, String player2){

        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        scorePanel = new JPanel();
        scorePanel.setPreferredSize(new Dimension(600, 100));
        this.setBackground(Color.BLUE);
        scorePanel.setBackground(Color.WHITE);

        p1 = new JLabel(player1 + ":  " + game.getPlayerScore1());
        p2 = new JLabel(player2 + ":  " + game.getPlayerScore2());
        p1.setOpaque(true);
        p2.setOpaque(true);
        p1.setBackground(Color.green);
        p2.setBackground(Color.yellow);
        p1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        p2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        p1.setForeground(myColor);
        p2.setForeground(myColor);


        s = new JRadioButton("S");
        o = new JRadioButton("O");
        s.addActionListener(new RadioListener());
        o.addActionListener(new RadioListener());
        s.setBackground(Color.yellow);
        o.setBackground(Color.yellow);
        s.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        o.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        s.setForeground(myColor);
        o.setForeground(myColor);

        scorePanel.add(p1);
        scorePanel.add(s);
        scorePanel.add(o);
        scorePanel.add(p2);

        canvas = new SOSCanvas(game);
        canvas.addMouseListener(new CanvasListener());
        canvas.setBackground(Color.yellow);

        canvas.setVisible(true);
        scorePanel.setVisible(true);
        this.add(canvas, BorderLayout.CENTER);
        this.add(scorePanel, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(800, 800));

    }

    private void reset() {

    }

    private class CanvasListener extends MouseAdapter{

        public void mousePressed(MouseEvent e) {

            Point p = e.getPoint();
            double xPosi = p.getX();
            double yPosi = p.getY();

            double boxEdge = canvas.getBoxEdge();

            int row = (int)yPosi / (int)boxEdge +1;
            int column = (int)xPosi / (int)boxEdge +1;

            if(s.isSelected()){
                game.play('s', column, row);
                p1.setText(player1 + ":  " + game.getPlayerScore1());
                p2.setText(player2 + ":  " + game.getPlayerScore2());

            }
            else if(o.isSelected()){
                game.play('o', column, row);
                p1.setText(player1 + ":  " + game.getPlayerScore1());
                p2.setText(player2 + ":  " + game.getPlayerScore2());
            }

            int turn = game.getTurn();

            if(turn == 1){
                p1.setBackground(Color.black);
                p2.setBackground(Color.white);
            }
            else if(turn == 2){
                p2.setBackground(Color.black);
                p1.setBackground(Color.white);
            }
            repaint();
            if(game.isGameOver()){

                String endMes = "";
                if(game.getPlayerScore1() > game.getPlayerScore2()){
                    endMes = player1 + " wins the gameee!!" ;
                }
                else if(game.getPlayerScore1() < game.getPlayerScore2()){
                    endMes = player2 + " wins the gameee!!";
                }
                else if(game.getPlayerScore1() == game.getPlayerScore2()){
                    endMes = "I's a Draw!! =)";
                }

                int again = JOptionPane.showConfirmDialog(canvas, endMes , "Game Over *-*",
                        JOptionPane.DEFAULT_OPTION);
                if(again == 0){
                    System.exit(0);
                }
            }
        }

    }

    private class RadioListener implements ActionListener{

        public void actionPerformed( ActionEvent e ){

            if((e.getSource()).equals(s)){
                o.setSelected(false);

            }

            else if((e.getSource()).equals(o)){
                s.setSelected(false);

            }

        }
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button2) {
                String selectedString = (String) comboBox.getSelectedItem();
                System.out.println(selectedString);
                dimenson = Integer.valueOf(selectedString);
            } else if (e.getSource() == button1) {
                System.exit(0);
            }
        }
    }
}
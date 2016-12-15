package GUIs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class Tetris extends JFrame {

    JLabel statusbar;
    JPanel statusPanel,piece1, piece2, piece3, piece4;
    JPanel[] upcomingPieces = {piece1, piece2, piece3, piece4};
    Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    Border loweredBevel = BorderFactory.createLoweredBevelBorder();
    Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
    public Tetris() {
        
        statusbar = new JLabel(" 0");
        statusPanel = new JPanel(new GridLayout(0,1));
        statusPanel.setPreferredSize(new Dimension(75,500));
        add(statusPanel, BorderLayout.EAST);
        for(JPanel panel:upcomingPieces){
            panel = new JPanel();
            panel.setBorder(compound);
            statusPanel.add(panel);
        }        
        statusPanel.add(statusbar);
        
        Board board = new Board(this);
        board.setBorder(loweredBevel);
        add(board);
        board.start();

        setSize(300, 500);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }

    public static void main(String[] args) {

        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true); 

    } 
}
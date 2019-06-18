package view;
import java.awt.*;
import javax.swing.*;
import controller.SquareButtonListener;
import model.*;


public class GamePanel extends JPanel{
  private Board board;

  public GamePanel(Game g, JFrame f){
    super();

    initComponent(g,f);
    //this.add(new SquareButton(1,2, new SquareButtonListener(f)));

  }

  public void initComponent(Game g, JFrame f){

    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    //c.fill = GridBagConstraints.BOTH;
    c.gridwidth = 1;
    c.gridheight = 1;

    JButton button = new JButton();

    board = g.getBoard();

    for (int i = 0 ; i < board.getSize() ; i++){
      c.gridx = i;

      for (int j = 0 ; j < board.getSize() ; j++){
        c.gridy = j;
        button = new SquareButton(i,j, new SquareButtonListener(f));
        // updateIcon(i,j);
        this.add(button,c);
      }
    }
  }

  public void updateIcon(int i, int j){
    Square s = this.board.getSquare(i,j);
    switch(s.getType()){
      case FENCE :
        break;

      case NONE :
        break;

      case FREEP :
        break;

      case FREEB :
        break;

      case P1 :
        break;

      case P2 :
        break;

      case TAKEABLE :
        break;

      case FORBIDDEN :
        break;
    }

  }

}

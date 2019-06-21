package view;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import controller.SquareButtonListener;
import model.*;


public class GamePanel extends JPanel{
  private Board board;
  private ArrayList<SquareButton> sBarray;
  private int[] lastClicked;

  public GamePanel(Game g, SwingUI f){
    super();

    initComponent(g,f);
    //this.add(new SquareButton(1,2, new SquareButtonListener(f)));

  }

  public void initComponent(Game g, SwingUI f){
    lastClicked = new int[2];
    lastClicked[0] = 0;
    lastClicked[1] = 0;

    int nbSquare = 0;
    this.sBarray = new ArrayList<SquareButton>();
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridwidth = 1;
    c.gridheight = 1;

    JButton button = new JButton();

    board = g.getBoard();
    //board.printBoard();

    for (int i = 0 ; i < board.getSize() ; i++){
      c.gridx = i;

      for (int j = 0 ; j < board.getSize() ; j++){
        c.gridy = j;
        button = new SquareButton(i,j,"../ressources/sqGray.png", new SquareButtonListener(f));
        this.sBarray.add((SquareButton)button);
        updateIcon(i,j, nbSquare);

        this.add(button,c);
        nbSquare ++;
      }
    }
  }

  public void setLastClicked(int x, int y){
    lastClicked[0] = x;
    lastClicked[1] = y;
  }

  public void updateIcon(int i, int j, int k){
    Square s = this.board.getSquare(j,i);

    switch(s.getType()){
      case FENCE :
        this.sBarray.get(k).setText("fence");
        break;

      case NONE :
        this.sBarray.get(k).setText("none");
        break;

      case FREEP :
        this.sBarray.get(k).setText("free");
        break;

      case FREEB :
        this.sBarray.get(k).setText("free");
        break;

      case P1 :
        this.sBarray.get(k).setText("P1");
        break;

      case P2 :
        this.sBarray.get(k).setText("P2");
        break;

      case TAKEABLE :
        this.sBarray.get(k).setText("o");
        break;

      case FORBIDDEN :
        this.sBarray.get(k).setText("XX");
        break;
    }

  }

  public void updateAllIcons(){
    int k = 0;
    for (int i = 0 ; i < board.getSize() ; i++){
      for (int j = 0 ; j < board.getSize() ; j++){
        updateIcon(i,j,k++);
      }
    }
  }

}

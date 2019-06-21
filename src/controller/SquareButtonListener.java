package controller;

import java.awt.event.*;
import javax.swing.*;
import view.SquareButton;
import view.*;
import model.HumanPlayer;

public class SquareButtonListener extends MouseAdapter{

  private SwingUI frame;
  private int lastPlayer;

  public SquareButtonListener(SwingUI f){
    this.frame = f;
    this.lastPlayer = 1;
    System.out.println("sbListerner created");

    //System.out.println(frame.getGame().toString());

  }

  public void mouseClicked(MouseEvent e){
    SquareButton sB = (SquareButton)e.getSource();
    int[] swap = new int[2];
    if (!((sB.getPos()[0]%2==0 && sB.getPos()[0] % 2 == 0))){
      if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
        System.out.println("("+sB.getPos()[0]+", " +sB.getPos()[1]+ ") RightClicked");
      }
      else {
        //((GamePanel)this.frame.getMainContainer()).setLastClicked(sB.getPos()[0], sB.getPos()[1]);
        swap[0] = sB.getPos()[1];
        swap[1] = sB.getPos()[0];
        //System.out.println("sbListerner created");

        if (this.frame.getGame().getCurrentPlayer() == 0 ){

          System.out.println("sbListerner p1");

          ((HumanPlayer)(frame.getGame().getPlayer1())).setClicked(swap);
          //this.frame.getGame().getBoard().checkMoves(frame.getGame().getPlayer2());
          //this.frame.getGame().getBoard().printBoard();
         // this.frame.update();
          this.frame.getGame().setCurrentPlayer(1);

        }
        else {
          System.out.println("sbListerner p2");

          ((HumanPlayer)(frame.getGame().getPlayer2())).setClicked(swap);
          //this.frame.getGame().getBoard().checkMoves(frame.getGame().getPlayer1());
          //this.frame.update();
          this.frame.getGame().setCurrentPlayer(0);

        }
//        System.out.println("("+sB.getPos()[0]+", " +sB.getPos()[1]+ ") LeftClicked");

      }
    }
    //this.frame.set
    //this.frame.validate();
    this.frame.update();
  }

  public void mouseEntered(MouseEvent e){
    SquareButton sB = (SquareButton)e.getSource();
    this.frame.update();

    //System.out.println("MouseOn : " + "("+sB.getPos()[0]+", " +sB.getPos()[1]+ ")");
  }
}

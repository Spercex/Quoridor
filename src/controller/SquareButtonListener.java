package controller;

import java.awt.event.*;
import javax.swing.*;
import view.SquareButton;
import view.*;
import model.HumanPlayer;

public class SquareButtonListener extends MouseAdapter{

  private SwingUI frame;

  public SquareButtonListener(SwingUI f){
    this.frame = f;
    //System.out.println(frame.getGame().toString());

  }

  public void mouseClicked(MouseEvent e){
    SquareButton sB = (SquareButton)e.getSource();
    if (!((sB.getPos()[0]%2==0 && sB.getPos()[0] % 2 == 0))){
      if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
        System.out.println("("+sB.getPos()[0]+", " +sB.getPos()[1]+ ") RightClicked");
      }
      else {
        //((GamePanel)this.frame.getMainContainer()).setLastClicked(sB.getPos()[0], sB.getPos()[1]);
        ((HumanPlayer)(frame.getGame().getPlayer1())).setClicked(sB.getPos());
//        System.out.println("("+sB.getPos()[0]+", " +sB.getPos()[1]+ ") LeftClicked");

      }
    }
  }

  public void mouseEntered(MouseEvent e){
    SquareButton sB = (SquareButton)e.getSource();

    //System.out.println("MouseOn : " + "("+sB.getPos()[0]+", " +sB.getPos()[1]+ ")");
  }
}

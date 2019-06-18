package controller;

import java.awt.event.*;
import javax.swing.*;
import view.SquareButton;

public class SquareButtonListener extends MouseAdapter{

  private JFrame frame;

  public SquareButtonListener(JFrame f){
    this.frame = f;
  }

  public void mouseClicked(MouseEvent e){
    SquareButton sB = (SquareButton)e.getSource();
    if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
      System.out.println("("+sB.getPos()[0]+", " +sB.getPos()[1]+ ") RightClicked");
    }
    else {
      System.out.println("("+sB.getPos()[0]+", " +sB.getPos()[1]+ ") LeftClicked");

    }
  }

  public void mouseEntered(MouseEvent e){
    SquareButton sB = (SquareButton)e.getSource();

    System.out.println("MouseOn : " + "("+sB.getPos()[0]+", " +sB.getPos()[1]+ ")");
  }
}

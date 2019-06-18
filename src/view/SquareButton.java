package view;
import java.awt.*;
import javax.swing.*;
import controller.SquareButtonListener;

public class SquareButton extends JButton{
  private int[] pos;

  public SquareButton(int x, int y, SquareButtonListener mouseAction){
    super();
    this.pos = new int[2];
    this.addMouseListener(mouseAction);
    this.pos[0] = x;
    this.pos[1] = y;

    try {
      this.setIcon(new ImageIcon(getClass().getResource("ressources/squareGray.png")));
    }
    catch (NullPointerException e){
      this.setText(x+","+y);
    }

    Dimension d;
    if (x % 2 == 0 && y % 2 == 0){
      d = new Dimension(10,10);

    }

    else if (x % 2 == 0){
    d = new Dimension(10,40);

    }

    else if (y % 2 == 0){
      d = new Dimension(40,10);

    }

    else {
      d = new Dimension(40,40);

    }


    this.setPreferredSize(d);
    this.setMaximumSize(d);
    this.setMinimumSize(d);

    //this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setContentAreaFilled(false);
  }

  public int[] getPos(){
    return this.pos;
  }
}

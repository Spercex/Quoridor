package view;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import controller.SquareButtonListener;

public class SquareButton extends JButton{
  private int[] pos;

  public SquareButton(int x, int y, String path, SquareButtonListener mouseAction){
    super();
    this.pos = new int[2];
    this.addMouseListener(mouseAction);
    this.pos[0] = x;
    this.pos[1] = y;

    try {
      //BufferedImage img = ImageIO.read(getClass().getResource("../ressources/pawn.png"));
      //this.setIcon(new ImageIcon(img));

      //this.setIcon(ImageIcon.creatImageIcon("../../ressources/pawn.png"));
    }
    catch (NullPointerException npe){
      this.setText(x+","+y);
    }
    /*catch (IOException e){
      this.setText(x+","+y);

    }*/

    Dimension d;
    if (x % 2 == 0 && y % 2 == 0){
      d = new Dimension(15,15);

    }

    else if (x % 2 == 0){
    d = new Dimension(15,60);

    }

    else if (y % 2 == 0){
      d = new Dimension(60,15);

    }

    else {
      d = new Dimension(60,60);

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

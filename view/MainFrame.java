/**
* @author SCHLOSSER M, LE FEUNTEUN F, BOURDIN M
*/

package Quoridor.view;

import javax.swing.*;
import java.awt.*;
import Quoridor.view.*;
//import controller.*;
//import model.*;

public class MainFrame extends JFrame{

  private ViewGridTable gridTable;
  private JFrame frame;

  public MainFrame(){
    this.initComponents();
  }

  public void initComponents(){

    frame = new JFrame("Quoridor");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.setTitle("Quoridor");

    this.setPreferredSize(new Dimension(600,600));
    this.setResizable(false);

    this.gridTable = new ViewGridTable();

    this.add(gridTable);

    this.pack();
    this.setVisible(true);
  }

  public static void main(String args[]){

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame();
      }
    });
  }

}

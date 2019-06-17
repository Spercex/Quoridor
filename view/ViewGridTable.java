/**
* @author SCHLOSSER M, LE FEUNTEUN F, BOURDIN M
*/

package Quoridor.view;

import javax.swing.*;
import java.awt.*;
import Quoridor.view.*;
//import controller.*;
//import model.*;

public class ViewGridTable extends JTable{

  private JTable table;

  public ViewGridTable(){
    this.initComponents();
  }

  public void initComponents(){

    this.table = new JTable(19,19);
    this.table.setBorder(BorderFactory.createCompoundBorder());

  }

}

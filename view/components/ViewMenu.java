/**
* @author SCHLOSSER M, LE FEUNTEUN F, BOURDIN M
*/

package view.components;

import javax.swing.*;
import java.awt.*;

import controller.*;
import model.*;
import view.*;
import view.buttons.*;

import java.util.*;
import java.text.*;

public class ViewCategorie extends JPanel{
  private JButton button;

  public ViewCategorie(PlayButtonCategorieController playButton, SettingsButtonController settingsButton, int numCat, Categorie cat){


    button = new PlayButtonCategorie(numCat, cat.getPath());
    this.button.setText(cat.getName());
    this.button.setMaximumSize(new Dimension(100,100));
    this.button.setVerticalTextPosition(AbstractButton.TOP);
    this.button.setHorizontalTextPosition(AbstractButton.CENTER);
    this.button.addActionListener(playButton);
    this.add(button);

  }

  public void initComponents(){

  }
}

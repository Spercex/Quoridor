/**
 * @author SCHLOSSER M, LE FEUNTEUN F, BOURDIN M
 */

package Quoridor.view.panes;

//import model.*;
//import controller.*;
import Quoridor.view.*;
import javax.swing.*;
import java.awt.*;

public class PanMenu extends JPanel{
		private JButton buttonPlay, buttonRanked, buttonRules, buttonQuit;

	public PanMenu(/*LES CONTROLLERS*/){
    //INSTANCIER LES JBUTTONS AVEC LES CONTROLLERS

		this.initComponent();
	}

	public void initComponent(){
    Font font = new Font("Arial", Font.BOLD,22);
    Font font1 = new Font("Arial", Font.BOLD,16);

    JLabel title = new JLabel("Quoridor");
    title.setFont(font);
    title.setVerticalAlignment(JLabel.CENTER);
    title.setHorizontalAlignment(JLabel.CENTER);

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(0,3,0,40));

		//init Jouer
		this.buttonPlay = new OvalButton("Jouer");
		// this.buttonPlay.addActionListener(new Ecouteur(this));
    buttonPlay.setVerticalAlignment(JLabel.CENTER);
    buttonPlay.setHorizontalAlignment(JLabel.CENTER);

		//init Classement
		this.buttonRanked = new OvalButton("Classement");
		//this.buttonRanked.addActionListener(new Ecouteur(this));
    buttonRanked.setVerticalAlignment(JLabel.CENTER);
    buttonRanked.setHorizontalAlignment(JLabel.CENTER);

		//init Reglement
		this.buttonRules = new OvalButton("Reglement");
		//this.buttonRules.addActionListener(new MenuEcouteur(this));
    buttonRules.setVerticalAlignment(JLabel.CENTER);
    buttonRules.setHorizontalAlignment(JLabel.CENTER);

		//init quit
		this.buttonQuit = new OvalButton("Quitter");
		//this.buttonQuit.addActionListener(new Ecouteur(this));
    buttonQuit.setVerticalAlignment(JLabel.CENTER);
    buttonQuit.setHorizontalAlignment(JLabel.CENTER);


    menu.add(new JLabel());
    menu.add(buttonPlay);
    menu.add(new JLabel());

    menu.add(new JLabel());
    menu.add(buttonRanked);
    menu.add(new JLabel());

    menu.add(new JLabel());
    menu.add(buttonRules);
    menu.add(new JLabel());

    menu.add(new JLabel());
    menu.add(buttonQuit);
    menu.add(new JLabel());


    this.setLayout(new BorderLayout());
    this.add(title, BorderLayout.NORTH);
    this.add(menu, BorderLayout.CENTER);
    this.add(new JLabel("© SCHLOSSER M, BOURDIN M, LE FEUNTEUN F"), BorderLayout.SOUTH);

	}

	public JButton getJouer(){
		return buttonPlay;
	}

	public JButton getClassement(){
		return buttonRanked;
	}

	public JButton getReglement(){
		return buttonRules;
	}

	public JButton getQuit(){
		return buttonQuit;
	}
	
// SET UN BG
//PLUS GROS ET MEILLEUR FORME

}

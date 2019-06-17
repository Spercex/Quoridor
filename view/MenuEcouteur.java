package controller;
import view.*;
import javax.swing.*;
import java.awt.event.*;

 
public class MenuEcouteur implements ActionListener{
	 Menu m1;
	
	public MenuEcouteur(Menu menu){
		this.m1 = menu;
	}
	

	public void actionPerformed(ActionEvent e){
		
		//pour afficher les regles du jeux
		if( e.getSource() == this.m1.getReglement() ){
			m1.setVisible(false);
			Reglement reg = new Reglement();
			reg.setVisible(true);
		}
				
	}
}

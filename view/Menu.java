package view;
import controller.*;
import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame{  

		private JPanel jr;
		private JPanel cls;
		private JPanel rgl;
		private JPanel quit;
		private JButton b1;
		private JButton b2;
		private JButton b3;
		private JButton b4;
		private JPanel p1;
	
	
	public static void main (String[] args){
    java.awt.EventQueue.invokeLater(new Runnable() {
		public void run(){
			new Menu().setVisible(true);
		}
    });
	}

  
	public Menu(){
		this.initComponent();
	}
	
	public void initComponent(){
		//init frame 
		JFrame frame = new JFrame();
		this.setPreferredSize(new Dimension(700,700));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Quoridor");
		this.setResizable(false);
		
		//Init panel
		this.setLayout(new GridLayout(5,1));
		p1 = new JPanel();
		jr = new JPanel();
		cls = new JPanel();
		rgl = new JPanel();
		quit = new JPanel();
		
		
		//init Jouer
		b1 = new JButton("Jouer");
		// this.b1.addActionListener(new Ecouteur(this));
		
		//init Classement
		b2 = new JButton("Classement");
		//this.b2.addActionListener(new Ecouteur(this));
		 
		//init Reglement
		b3 = new JButton("Reglement");
		this.b3.addActionListener(new MenuEcouteur(this));
		
		//init quit
		b4 = new JButton("Quit");
		//this.b4.addActionListener(new Ecouteur(this)); 
		
		
		//add
		jr.add(b1);
		cls.add(b2);
		rgl.add(b3);
		quit.add(b4);
		
		this.add(p1);
		this.add(jr);
		this.add(cls);
		this.add(rgl);
		this.add(quit);
		pack();
	}
	
	public JButton getJouer(){
		return b1;
	}
	
	public JButton getClassement(){
		return b2;
	}
	
	public JButton getReglement(){
		return b3;
	}
	
	public JButton getQuit(){
		return b4;
	}
	 
}
  
  
  


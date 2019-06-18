package view;
import java.awt.*;
import javax.swing.*;

import model.Game;

public class SwingUI extends JFrame implements UI{

		private JPanel mainContainer;
		private Game g;


	public static void main (String[] args){
    java.awt.EventQueue.invokeLater(new Runnable() {
		public void run(){
			new SwingUI();
		}
    });
	}


	public SwingUI(Game g){
		this.g=g;
		this.initComponent(g);
	}

	public void initComponent(){
		//init frame

		JFrame frame = new JFrame();
		this.setPreferredSize(new Dimension(700,700));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Quoridor");
		this.setResizable(false);

		mainContainer = new GamePanel(g, this);
		this.add(mainContainer);
		this.setVisible(true);
		pack();
	}

	public void setGame(Game g){
		this.game = g
	}

	public void update(){
		this.remove(mainContainer);
		this.mainContainer = new GamePanel(g, this);
		this.add(mainContainer);
	}

}

package view;
import java.awt.*;
import javax.swing.*;
import model.Game	;

public class SwingUI extends JFrame implements UI{

		private JPanel mainContainer;
		private Game g;


	public SwingUI(Game g){
		this.initComponent(g);
	}

	public void initComponent(Game g){
		//init frame

		JFrame frame = new JFrame();
		this.setPreferredSize(new Dimension(800,800));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Quoridor");
		this.setResizable(false);

		mainContainer = new GamePanel(g, this);
		this.add(mainContainer);
		this.setVisible(true);
		this.g = g;
		pack();
	}

	public void setGame(Game g){
		this.g = g;
	}

	public Game getGame(){
		return this.g;
	}

	public JPanel getMainContainer(){
		return this.mainContainer;
	}

	public void loadGamePanel(){
		mainContainer = new GamePanel(g, this);
	}

	public void update(){
		this.remove(mainContainer);
		this.mainContainer = new GamePanel(g, this);
		this.mainContainer.validate();
		this.add(mainContainer);
		this.repaint();
	}

}

package view;
import java.awt.*;
import javax.swing.*;
public class Reglement extends JFrame{  
	private JPanel p1;
	private JLabel desc;
	private JPanel p2;
	private JLabel text;
	private JButton b1;

	public Reglement(){
		this.initComponent();
	}
	
	public void initComponent(){
		
		
		//init frame 
		JFrame frame = new JFrame();
		this.setPreferredSize(new Dimension(500,500));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Reglement");
		this.setResizable(false);
		
		//Init panel
		this.setLayout(new GridLayout(1,3));
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		//Init Text
		desc = new JLabel("Voici la description du jeux");

		//init text
		text = new JLabel("  ");
		
		//init button retour
		b1 = new JButton();
		
		//add

		p1.add(desc);
		

		this.add(p1);
		pack();
	}
}
  
  

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
	
	private JPanel center;
	private PanelMenu paneMenu;
	private PanelSetGame paneSetGame;
	private PanelRule paneRule;
	private PanelRank paneRank;
	private PanelGame paneGame;
  
	private JScrollPane scroll;
	
	
	private PaneCenter lastPane;


	public MainFrame(){
		super("Quoridor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents();
	}

	public void initComponents(){

		this.setTitle("Quoridor");
		this.setPreferredSize(new Dimension(600,600));
		this.setResizable(false);

		this.scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setLayout(new BorderLayout());
		
		this.paneMenu = new PanelMenu(/*new PlayButtonController(this), new RankButtonControler(this),new RuleButtonController(this),new QuitButtonController(this)*/);
		this.paneSetGame = new PanelSetGame(/*new QuitButtonController(this),xx*/);
		this.paneRule = new PanelRule(/*new QuitButtonController(this)*/);
		this.paneRank = new PanelRank(/*new QuitButtonController(this)*/);
		this.panelGame = new PanelGame(/*xxx*/);
		
		this.center = paneMenu;
		this.add(paneMenu, BorderLayout.CENTER);

		this.pack();
		this.setVisible(true);
	}



	public void switchPane(PaneCenter p){
        switch (p){
            case PLAY:

                this.remove(paneCenter);
                this.paneCCat = new PanelCategorie(model.getCategories(),this);
                this.paneC = this.paneCCat;
                this.add(paneC, BorderLayout.CENTER);


               break;

            case RANK:
                this.remove(paneCenter);
                this.paneCAct = new PanelActivity(model.getCategories().get(this.currentCat).getActivites(),new SettingsButtonController(this),
                        new PlayButtonActivityController(this), new MoreButtonController(this));
                this.paneC = this.paneCAct;
                this.add(paneC, BorderLayout.CENTER);


                break;

            case RULE:
                this.remove(paneCenter);
                this.paneCEta = new PanelEtapes(model.getCategories(),getCurrentCat(),getCurrentAct());
                this.paneC = this.paneCEta;
                this.add(paneC, BorderLayout.CENTER);



                break;

           
        }
    }



}

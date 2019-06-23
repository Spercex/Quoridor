/**
 * @author SCHLOSSER M, LE FEUNTEUN F, BOURDIN M
 */

package Quoridor.view;

import javax.swing.*;
import java.awt.*;
import Quoridor.view.*;
import Quoridor.view.panes.*;
//import controller.*;
//import model.*;

public class MainFrame extends JFrame{
    private PanRules paneRules;
    private PanMenu paneMenu;


    public MainFrame(){
        super("Quoridor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initComponents();
    }

    public void initComponents(){
        this.setTitle("Quoridor");
        this.setPreferredSize(new Dimension(600,600));
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        //this.paneRules = new PanRules();
        //this.add(paneRules, BorderLayout.CENTER);
        this.paneMenu = new PanMenu();
        this.add(paneMenu, BorderLayout.CENTER);
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

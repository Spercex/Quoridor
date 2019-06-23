/**
 * @author SCHLOSSER M, LE FEUNTEUN F, BOURDIN M
 */

package Quoridor.view.panes;

//import model.*;
//import controller.*;
//import view.*;
import javax.swing.*;
import java.awt.*;

public class PanRules extends JPanel{
    public JButton back;
    private JScrollPane scroll;

    public PanRules(/*BackButtonController backController*/){
        // this.back = new BackButton();
        // this.back.addActionListener((backController));

        this.initComponents();
    }

    public void initComponents(){
        Font font = new Font("Arial", Font.BOLD,22);
        Font font1 = new Font("Arial", Font.BOLD,16);
        Font font2 = new Font("Arial", Font.BOLD,14);

        JLabel title = new JLabel("RÈGLES DU JEU");
        title.setFont(font);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(0,1,0,20));

        this.scroll = new JScrollPane(text);
        scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel but = new JLabel("                   = BUT DU JEU =");
        but.setFont(font1);
        but.setVerticalAlignment(JLabel.CENTER);

        JLabel but1 = new JLabel("<html>Atteindre le premier la ligne opposée à sa ligne de départ (fig 7)<html/>");

        JLabel rule2 = new JLabel("                   = REGLE POUR 2 JOUEURS =");
        rule2.setFont(font1);
        rule2.setVerticalAlignment(JLabel.CENTER);

        JLabel rule2Bis = new JLabel("<html>En début de partie, les barrières sont remisées dans leur zone de stockage <br/>(10 par joueur). Chaque joueur pose son pion au centre de sa ligne de départ (fig 1).<br/>Un tirage au sort détermine qui commence.</html>");

        JLabel deroul = new JLabel("     - Déroulement d'une partie");
        deroul.setFont(font2);
        deroul.setVerticalAlignment(JLabel.CENTER);

        JLabel deroul1 = new JLabel("<html>A tour de rôle, chaque joueur choisit de déplacer son pion ou de poser une de ses <br/>barrières. Lorsqu’il n’a plus de barrières, un joueur est obligé de déplacer son pion.</html>");

        JLabel move = new JLabel("     - Déplacement des pions");
        move.setFont(font2);
        move.setVerticalAlignment(JLabel.CENTER);

        JLabel move1 = new JLabel("<html>Les pions se déplacent d’une case, horizontalement ou verticalement, en avant ou <br/>en arrière (fig 2) ; les barrières doivent être contournées (fig 3).</html>");

        JLabel fence = new JLabel("      - Pose des barrières");
        fence.setFont(font2);
        fence.setVerticalAlignment(JLabel.CENTER);

        JLabel fence1 = new JLabel("<html>Une barrière doit être posée exactement entre 2 blocs de 2 cases (fig 4).<br/>La pose des barrières a pour but de se créer son propre chemin ou de ralentir <br/>l’adversaire, mais il est interdit de lui fermer totalement l’accès à sa ligne de but : <br/>il faut toujours lui laisser une solution (fig 5).</html>");

        JLabel face2face = new JLabel("      - Face à face");
        face2face.setFont(font2);
        face2face.setVerticalAlignment(JLabel.CENTER);

        JLabel face2face1 = new JLabel("<html>Quand les 2 pions se retrouvent en vis-à-vis sur 2 cases voisines non séparées par <br/>une barrière, le joueur dont c’est le tour peut sauter son adversaire et se placer <br/>derrière lui (fig 6).Si une barrière est située derrière le pion sauté, le joueur peut <br/>choisir de bifurquer à droite ou à gauche du pion sauté (fig 8 et 9).</html>");

        JLabel endGame = new JLabel("                   = FIN DE LA PARTIE =");
        endGame.setFont(font1);
        endGame.setVerticalAlignment(JLabel.CENTER);

        JLabel endGame1 = new JLabel("<html>Le premier joueur qui atteint une des 9 cases de la ligne opposée à sa ligne de <br/>départ gagne la partie (fig 7).</html>");

        JLabel time = new JLabel("                   = DUREE D'UNE PARTIE =");
        time.setFont(font1);
        time.setVerticalAlignment(JLabel.CENTER);

        JLabel time1 = new JLabel("<html>De 10 à 20 minutes.<br/>En tournoi, il est possible d’allouer à chaque joueur un temps limité.</html>");

        JLabel rule4 = new JLabel("                   = REGLE POUR 4 JOUEURS =");
        rule4.setFont(font1);
        rule4.setVerticalAlignment(JLabel.CENTER);

        JLabel rule4Bis = new JLabel("<html>En début de partie, les 4 pions sont disposés au centre de chacun des 4 cotés du <br/>plateau et chaque joueur dispose de 5 barrières. Les règles sont strictement <br/>identiques, mais on ne peut sauter plus d’un pion à la fois (fig 10)</html>");


        text.add(but);
        text.add(but1);
        text.add(rule2);
        text.add(rule2Bis);
        text.add(deroul);
        text.add(deroul1);
        text.add(move);
        text.add(move1);
        text.add(fence);
        text.add(fence1);
        text.add(face2face);
        text.add(face2face1);
        text.add(endGame);
        text.add(endGame1);
        text.add(time);
        text.add(time1);
        text.add(rule4);
        text.add(rule4Bis);
        text.add(new JLabel());

        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
      //  this.add(back, BorderLayout.SOUTH);
    }
}

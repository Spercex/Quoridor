package view.buttons;

import javax.swing.*;
import java.awt.*;

public class RankingButton extends JButton{
    private String path;
    private Image img;

    public RankingButton(){
        super("");
        this.path = "../../resources/Ranking.png";
        try {
            this.setIcon(new ImageIcon(getClass().getResource(this.path)));
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
//        this.addActionListener(RankingButton.java);
        this.setPreferredSize(new Dimension(80,80));
        this.setVerticalTextPosition(AbstractButton.CENTER);
        this.setHorizontalTextPosition(AbstractButton.CENTER);
    }


}

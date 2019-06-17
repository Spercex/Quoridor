package view.buttons;

import javax.swing.*;
import java.awt.*;

public class PlayButton extends JButton{
    private String path;
    private Image img;

    public PlayButton(){
        super("");
        this.path = "../../resources/Play.png";
        try {
            this.setIcon(new ImageIcon(getClass().getResource(this.path)));
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
//        this.addActionListener(PlayButton.java);
        this.setPreferredSize(new Dimension(80,80));
        this.setVerticalTextPosition(AbstractButton.CENTER);
        this.setHorizontalTextPosition(AbstractButton.CENTER);
    }


}

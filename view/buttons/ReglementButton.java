package view.buttons;

import javax.swing.*;
import java.awt.*;

public class ReglementButton extends JButton{
    private String path;
    private Image img;

    public ReglementButton(){
        super("");
        this.path = "../../resources/Reglement.png";
        try {
            this.setIcon(new ImageIcon(getClass().getResource(this.path)));
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
//        this.addActionListener(ReglementButton.java);
        this.setPreferredSize(new Dimension(80,80));
        this.setVerticalTextPosition(AbstractButton.CENTER);
        this.setHorizontalTextPosition(AbstractButton.CENTER);
    }


}

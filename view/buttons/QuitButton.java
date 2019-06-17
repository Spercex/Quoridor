package view.buttons;

import javax.swing.*;
import java.awt.*;

public class QuitButton extends JButton{
    private String path;
    private Image img;

    public QuitButton(){
        super("");
        this.path = "../../resources/Quit.png";
        try {
            this.setIcon(new ImageIcon(getClass().getResource(this.path)));
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
//        this.addActionListener(QuitButton.java);
        this.setPreferredSize(new Dimension(80,80));
        this.setVerticalTextPosition(AbstractButton.CENTER);
        this.setHorizontalTextPosition(AbstractButton.CENTER);
    }


}

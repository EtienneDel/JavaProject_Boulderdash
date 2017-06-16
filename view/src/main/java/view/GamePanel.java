package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GamePanel extends JPanel {

    private BufferedImage image;

    public GamePanel() {
        image= new BufferedImage(1, 1, 1);
    }

    public void setImage(BufferedImage image){
        this.image = image;
        repaint();
    }

    public void paintComponent(Graphics g){
        g.drawImage(image, 5,5, null);
    }
}

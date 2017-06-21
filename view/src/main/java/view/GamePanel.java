package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GamePanel extends JPanel {

    private BufferedImage image;
    private int x;
    private int y;


    public GamePanel() {
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    public void setImage(BufferedImage image, int x, int y){

        this.image = image;
        this.x = x;
        this.y = y;

        repaint();
    }

    public void paintComponent(Graphics g){
        g.drawImage(image, x, y, null);

    }
}

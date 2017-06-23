package model;
/**
 * <h1>the SpriteSheet class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * The type Sprite sheet.
 */
public class SpriteSheet extends JLabel{

    /**
     * attribute
     */
    BufferedImage img = ImageIO.read(new File(".\\SpriteSheet.png"));

    /**
     * constructor without parameter
     *
     * @throws IOException the io exception
     */
    public SpriteSheet() throws IOException {

    }

    /**
     * get the image
     *
     * @return buffered image
     */
    public BufferedImage getImg(){
        return img;
    }

}

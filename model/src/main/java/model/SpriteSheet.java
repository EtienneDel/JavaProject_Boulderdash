package model;
/**
 * <h1>the SpriteSheet class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.List;

public class SpriteSheet extends JLabel implements IModel {

    final int width = 16, height = 16, row = 24, col = 18;
    BufferedImage img = ImageIO.read(new File(".\\SpriteSheet.png"));
    //BufferedImage[] sprite = new BufferedImage[row * col];

    /**
     * constructor
     * @throws IOException
     */
    public SpriteSheet() throws IOException {

    }

    /**
     * get the image
     * @return
     */
    public BufferedImage getImg(){
        return img;
    }

    public BufferedImage crop(int x, int y, int height, int width){
        return img.getSubimage(x,y,width,height);
    }



    @Override
    public Example getExampleById(int id) throws SQLException {
        return null;
    }

    /**
     * get an example by his name
     * @param name
     *            the name
     * @return
     * @throws SQLException
     */
    @Override
    public Example getExampleByName(String name) throws SQLException {
        return null;
    }

    /**
     * get all examples
     * @return
     * @throws SQLException
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return null;
    }
}

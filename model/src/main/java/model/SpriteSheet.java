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
import java.util.ArrayList;

/**
 * The type Sprite sheet.
 */
public class SpriteSheet extends JLabel implements IModel{

    /**
     * attribute
     */
    BufferedImage gameOver = ImageIO.read(new File(".\\gameOver.jpg"));
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
    public BufferedImage getImg() {
        return img;
    }

    @Override
    public BufferedImage getGameOver(){return gameOver;}

    @Override
    public int getMap_width() {
        return 0;
    }

    @Override
    public int getMap_height() {
        return 0;
    }

    @Override
    public char[][] getTab_map() {
        return new char[0][];
    }

    @Override
    public void setTab_map(char[][] tab_map) {

    }

    @Override
    public Assetable getAssets() {
        return null;
    }

    @Override
    public IMap getTheMap() throws IOException {
        return null;
    }

    @Override
    public IPosition getPosition(int x, int y) {
        return null;
    }

    @Override
    public IRock getRock() throws IOException {
        return null;
    }

    @Override
    public IDiamond getDiamond() throws IOException {
        return null;
    }

    @Override
    public int getDiamonds() {
        return 0;
    }

    @Override
    public ICharacter setTheCharacterA(int x, int y) throws IOException {
        return null;
    }

    @Override
    public ICharacter getTheCharacterA() throws IOException {
        return null;
    }

    @Override
    public ArrayList<IEnemies> createEnemyList() throws IOException {
        return null;
    }
}

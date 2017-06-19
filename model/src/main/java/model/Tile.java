package model;
/**
 * <h1>the Tile class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static int WIDTH = 16;
    public static int HEIGHT = 16;
    private Position position;
    private ImageIcon img;
    public static int REF;
    private boolean isWalkable = true;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Tile() {
        setWalkable(true);

    }

    //TODO revoir cette fonction
    public int getRefByPos(int x, int y) {
        return Integer.parseInt(null);
    }

    /**
     * set the position of the tile
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        position.setPosX(x);
        position.setPosY(y);
    }

    /**
     * set if we can walk on the tile or not
     * @param walkable
     */
    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    public BufferedImage getImageFromTileset(BufferedImage tileset) {
        int x = REF%18*16;
        int y = REF/18*16;

        return tileset.getSubimage(x, y, 16, 16);
    }
}
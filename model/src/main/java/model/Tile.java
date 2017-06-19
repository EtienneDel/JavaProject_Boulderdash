package model;
/**
 * <h1>the Tile class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
import model.dao.MapDAO;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Tile {

    protected Position position;
    public static int WIDTH = 16;
    public static int HEIGHT = 16;
    private ImageIcon img;
    public static int ref;
    private boolean isWalkable = true;
    private MapDAO mapDAO;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Tile(int x, int y, MapDAO mapDAO) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);
        this.mapDAO = mapDAO;

    }
    public Tile(int x, int y) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);


    }

    //TODO revoir cette fonction
    public char getCharByPos(int x, int y) {

    char[][] tablemap = mapDAO.getTablemap();



        return  tablemap[x][y];
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
     * get the id/reference of the tile
     * @return
     */
    public int getRef() {
        return ref;
    }

    /**
     * set the id of the tile
     * @param ref
     */
    public void setRef(int ref) {
        this.ref = ref;
    }

     /**
     * set if we can walk on the tile or not
     * @param walkable
     */
    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    public boolean getWalkable(){
        return this.isWalkable;
    }

    public Position getPosition() {
        return position;
    }

    public BufferedImage getImageFromTileset(BufferedImage tileset) {
        int x = ref%18*16;
        int y = ref/18*16;

        return tileset.getSubimage(x, y, 16, 16);
    }
}
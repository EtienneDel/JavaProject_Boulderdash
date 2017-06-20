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
import java.io.IOException;
import java.sql.SQLException;

public class Tile {

    protected Position position;
    public static int WIDTH = 16;
    public static int HEIGHT = 16;
    private ImageIcon img;
    public static int REF;
    private boolean isWalkable = true;
    private MapDAO mapDAO;
    private char tablemap[][];

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
    public Tile() {

        setRef(2);
        setWalkable(true);


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
        return REF;
    }

    /**
     * set the id of the tile
     * @param ref
     */
    public void setRef(int ref) {
        this.REF = ref;
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

    public BufferedImage getImageFromTileset(BufferedImage tileset,int i,int j) {
        int x = i*16;
        int y = j*16;

        return tileset.getSubimage(x, y, 16, 16);
    }

    public void setMapDAO(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public void setTablemap(char[][] tablemap) {
        this.tablemap = tablemap;
    }
}
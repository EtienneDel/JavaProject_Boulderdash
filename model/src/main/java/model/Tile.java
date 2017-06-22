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

public class Tile implements Tilable {

    /**
     * attributes
     */
    public static int WIDTH = 16;
    public static int HEIGHT = 16;
    public static int REF;
    protected Position position;
    private ImageIcon img;
    private boolean isWalkable = true;
    private MapDAO mapDAO;
    private char tablemap[][];

    /**
     * Constructor with parameter position and MapDAO
     *
     * @param x
     * @param y
     */
    public Tile(int x, int y, MapDAO mapDAO) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);
        this.mapDAO = mapDAO;

    }

    /**
     * constructor with parameter only the position
     * @param x
     * @param y
     */
    public Tile(int x, int y) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);


    }

    /**
     * constructor without parameter
     */
    public Tile() {

        setRef(2);
        setWalkable(true);


    }



    /**
     * get the image associate to this tile
     * @param tileset
     * @param i
     * @param j
     * @return
     */
    public BufferedImage getImageFromTileset(BufferedImage tileset, int i, int j) {
        int x = i * 16;
        int y = j * 16;

        return tileset.getSubimage(x, y, 16, 16);
    }

    /**
     * set the position of the tile
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        position.setPosX(x);
        position.setPosY(y);
    }

    public void setPosition(Position position) {
        this.position = new Position(position);
    }

    /**
     * get the id/reference of the tile
     *
     * @return
     */
    public int getRef() {
        return REF;
    }

    @Override
    public void setPosition(IPosition position) {
        this.position = (Position) position;
    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }

    /**
     * set the id of the tile
     *
     * @param ref
     */
    public void setRef(int ref) {
        this.REF = ref;
    }

    public boolean getWalkable() {
        return this.isWalkable;
    }

    /**
     * set if we can walk on the tile or not
     *
     * @param walkable
     */
    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    /**
     * getter and setter
     * @return
     */
    public IPosition getPosition() {
        return position;
    }



    public void setMapDAO(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public void setTablemap(char[][] tablemap) {
        this.tablemap = tablemap;
    }
}
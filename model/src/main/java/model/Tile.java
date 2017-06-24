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

/**
 * The type Tile.
 */
public class Tile implements Tilable {

    /**
     * attributes
     */
    public static int WIDTH = 16;
    /**
     * The constant HEIGHT.
     */
    public static int HEIGHT = 16;
    /**
     * The constant REF.
     */
    public static int REF;
    /**
     * The Position.
     */
    public Position position;
    private ImageIcon img;
    private boolean isWalkable = true;
    private MapDAO mapDAO;
    private char tablemap[][];

    /**
     * Constructor with parameter position and MapDAO
     *
     * @param x      the x
     * @param y      the y
     * @param mapDAO the map dao
     */
    public Tile(int x, int y, MapDAO mapDAO) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);
        this.mapDAO = mapDAO;

    }

    /**
     * constructor with parameter only the position
     *
     * @param x the x
     * @param y the y
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
     *
     * @param tileset the tileset
     * @param i       the
     * @param j       the j
     * @return image from tileset
     */
    public BufferedImage getImageFromTileset(BufferedImage tileset, int i, int j) {
        int x = i * 16;
        int y = j * 16;

        return tileset.getSubimage(x, y, 16, 16);
    }

    /**
     * set the position of the tile
     *
     * @param x the x
     * @param y the y
     */
    public void setPosition(int x, int y) {
        position.setPosX(x);
        position.setPosY(y);
        System.out.println(position.getPosX() + " " + position.getPosY());
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
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

    /**
     * set the id of the tile
     *
     * @param ref the ref
     */
    public void setRef(int ref) {
        REF = ref;
    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }

    /**
     * Gets walkable.
     *
     * @return the walkable
     */
    public boolean getWalkable() {
        return this.isWalkable;
    }

    /**
     * set if we can walk on the tile or not
     *
     * @param walkable the walkable
     */
    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    /**
     * getter and setter
     *
     * @return position position
     */
    @Override
    public IPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(IPosition position) {
        this.position = (Position) position;
    }

    /**
     * Sets map dao.
     *
     * @param mapDAO the map dao
     */
    public void setMapDAO(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    /**
     * Sets tablemap.
     *
     * @param tablemap the tablemap
     */
    public void setTablemap(char[][] tablemap) {
        this.tablemap = tablemap;
    }
}
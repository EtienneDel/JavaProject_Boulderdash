package model;
/**
 * <h1>the Tile class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
import javax.swing.*;

public class Tile {

    protected static int WIDTH = 16;
    protected static int HEIGHT = 16;
    private Position position;
    private ImageIcon img;
    private int ref;
    private boolean isWalkable = true;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Tile(int x, int y) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);

    }

    //TODO revoir cette fonction
    public Tile gettileByPos(int x, int y) {
        return null;
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

    public boolean getWalkable(){
        return this.isWalkable;
    }

    public Position getPosition() {
        return position;
    }
}
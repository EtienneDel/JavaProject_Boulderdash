package model;
/**
 * <h1>the Character class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

public class Character extends Entitie implements Tilable {
    /**
     * attribute
     */
    public final static int REF = 8;
    /**
     * constructor with parameter position of the tile
     * @param x
     * @param y
     */
    public Character(int x, int y) {
        super(x, y);
        setWalkable(false);


    }

    /**
     * constructor without parameter
     */
    public Character() {
        super();
        setWalkable(false);


    }
}

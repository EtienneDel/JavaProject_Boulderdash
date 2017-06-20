package model;
/**
 * <h1>ths Empty class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Empty extends Tile {

    /**
     * attribute
     */
    public final static int REF = 2;
    /**
     * constructor with parameter position of the tile
     * @param x
     * @param y
     */
    public Empty(int x, int y) {

        super(x,y);
        setWalkable(true);

    }

    /**
     * constructor without parameter
     */
    public Empty() {


        setWalkable(true);

    }
}

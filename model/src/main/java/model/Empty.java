package model;
/**
 * <h1>ths Empty class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Empty extends Tile {

    public final static int REF = 2;
    /**
     * constructor
     * @param x
     * @param y
     */
    public Empty(int x, int y) {

        setWalkable(true);

    }
}

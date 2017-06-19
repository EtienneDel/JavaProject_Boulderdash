package model;
/**
 * <h1>the Exit class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Exit extends Tile {

    public final static int REF = 6;
    /**
     * constructor
     * @param x
     * @param y
     */
    public Exit(int x, int y) {

        setWalkable(true);

    }

    /**
     * you win !
     */
    public void endLevel() {


    }
}

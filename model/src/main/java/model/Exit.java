package model;
/**
 * <h1>the Exit class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Exit extends Tile {
    /**
     * constructor
     * @param x
     * @param y
     */
    public Exit(int x, int y) {
        super(x, y);
        setRef(6);
        setWalkable(true);

    }

    /**
     * you win !
     */
    public void endLevel() {


    }
}

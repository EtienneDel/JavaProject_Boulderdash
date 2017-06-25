package model;

/**
 * <h1>the Exit class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Exit extends Tile {

    /**
     * attribute
     */
    public final static int REF = 6;

    /**
     * constructor with parameter position of the tile
     *
     * @param x the x
     * @param y the y
     */
    public Exit(int x, int y) {

        super(x, y);
        setWalkable(true);

    }

    /**
     * constructor without parameter
     */
    public Exit() {
        super();
        setWalkable(true);

    }

    /**
     * you win !
     *
     * @return the string
     */
    public String endLevel() {

        String thisistheend = "THE END"; // BREAK EVERYTHING
        return thisistheend;

    }
}

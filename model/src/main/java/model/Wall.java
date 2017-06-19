package model;
/**
 * <h1>the Wall class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Wall extends Tile {

    public static int REF = 1;
    /**
     * Constructor
     * @param x
     * @param y
     */
    public Wall(int x, int y) {

        setWalkable(false);

    }
}

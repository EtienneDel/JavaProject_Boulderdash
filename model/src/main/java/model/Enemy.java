package model;
/**
 * <h1>the Enemy class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Enemy extends Entitie {

    public static int REF = 7;
    /**
     * constructor
     *
     * @param x
     * @param y
     */
    public Enemy(int x, int y) {
        super(x, y);
        setWalkable(false);

    }

}

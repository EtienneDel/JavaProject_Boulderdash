package model;
/**
 * <h1>the Enemy class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Enemy extends Entitie {

    /**
     * attributes
     */
    public final static int REF = 7;
    public int lastDirection;

    /**
     * constructor with parameter position of the tile
     *
     * @param x
     * @param y
     */
    public Enemy(int x, int y) {
        super(x, y);
        setWalkable(false);

    }

    /**
     * constructor without parameter
     */
    public Enemy() {
        super();
        setWalkable(false);

    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }
}

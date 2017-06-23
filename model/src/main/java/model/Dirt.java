package model;

/**
 * <h1>the Dirt class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Dirt extends Tile implements Breakable {

    /**
     * attribute
     */
    public final static int REF = 0;

    /**
     * constructor with parameter position of the tile
     *
     * @param x the x
     * @param y the y
     */
    public Dirt(int x, int y) {
        super(x, y);
        setWalkable(true);

    }

    /**
     * constructor without parameters
     */
    public Dirt() {

        setWalkable(true);

    }

    /**
     * when the character dig the dirt
     */
    @Override
    public void isBreak() {
    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }
}

package model;
/**
 * <h1>the Dirt class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Dirt extends Tile implements Breakable {

    public final static int REF = 0;
    /**
     * constructor
     * @param x
     * @param y
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
}

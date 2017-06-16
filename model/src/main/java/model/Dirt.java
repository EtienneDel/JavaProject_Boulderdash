package model;
/**
 * <h1>the Dirt class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Dirt extends Tile implements Breakable {
    /**
     * constructor
     * @param x
     * @param y
     */
    public Dirt(int x, int y) {
        super(x, y);
        setRef(0);
        setWalkable(true);

    }

    /**
     * when the character dig the dirt
     */
    @Override
    public void isBreak() {

        setRef(2);
    }
}

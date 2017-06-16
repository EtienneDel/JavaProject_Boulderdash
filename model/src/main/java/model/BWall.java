package model;
/**
 * <h1>the BWall class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

public class BWall extends Tile implements Breakable {
    /**
     * constructor
     * @param x
     * @param y
     */
    public BWall(int x, int y) {
        super(x, y);
        setRef(3);

    }

    /**
     * if the object break
     */
    @Override
    public void isBreak() {

        setRef(2);
        setWalkable(false);

    }
}

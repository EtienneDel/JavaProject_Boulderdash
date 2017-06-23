package model;
/**
 * <h1>the BWall class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.io.IOException;

/**
 * The type B wall.
 */
public class BWall extends Tile implements Breakable, Tilable {

    /**
     * attributes
     */
    public final static int REF = 3;


    /**
     * constructor without parameter
     *
     * @throws IOException the io exception
     */
    public BWall() throws IOException {
        super();


    }

    /**
     * constructor with position of the tile
     *
     * @param x the x
     * @param y the y
     * @throws IOException the io exception
     */
    public BWall(int x, int y) throws IOException {
        super(x,y);

    }

    /**
     * if the object break
     */
    @Override
    public void isBreak() {
        setWalkable(false);

    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }
}

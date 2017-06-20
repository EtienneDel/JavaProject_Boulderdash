package model;
/**
 * <h1>the BWall class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.io.IOException;

public class BWall extends Tile implements Breakable {

    /**
     * attributes
     */
    public final static int REF = 3;


    /**
     * constructor without parameter
     * @throws IOException
     */
    public BWall() throws IOException {
        super();


    }

    /**
     * constructor with position of the tile
     * @param x
     * @param y
     * @throws IOException
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
}

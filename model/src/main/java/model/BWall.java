package model;
/**
 * <h1>the BWall class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.io.IOException;

public class BWall extends Tile implements Breakable {

    public final static int REF = 3;

    public BWall() throws IOException {
        super();

    }

    /**
     * if the object break
     */
    @Override
    public void isBreak() {
        setWalkable(false);

    }
}

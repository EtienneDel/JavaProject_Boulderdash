package model;
/**
 * <h1>the Diamond class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.io.IOException;

public class Diamond extends Tile implements Breakable, Movable {
    /**
     * attribute
     */
    public final static int REF = 4;

    /**
     * constructor with parameter position of the tile
     * @param x
     * @param y
     * @throws IOException
     */
    public Diamond(int x, int y) throws IOException {
        super(x, y);
        setWalkable(true);

    }

    /**
     * constructor without parameter
     * @throws IOException
     */
    public Diamond() throws IOException {
        super();
        setWalkable(true);

    }




    /**
     * if the diamond is taken
     */
    @Override
    public void isBreak() {
    }

    /**
     * move up
     * @param position
     */
    @Override
    public void moveU(Position position) {
    }

    /**
     * move down
     * @param position
     */
    @Override
    public void moveD(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y+1);
    }

    /**
     * move left
     * @param position
     */
    @Override
    public void moveL(Position position) {
    }

    /**
     * move right
     * @param position
     */
    @Override
    public void moveR(Position position) {
    }
}

package model;
/**
 * <h1>the Diamond class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.io.IOException;

public class Diamond extends Tile implements Breakable, Movable, IDiamond {
    /**
     * attribute
     */
    public final static int REF = 4;
    private Map map = Map.getMap();
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
    public void moveU(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y-1, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
    }

    /**
     * move Down
     * @param position
     */
    @Override
    public void moveD(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y+1, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
    }

    /**
     * move left
     * @param position
     */
    @Override
    public void moveL(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x-1, y, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
    }

    /**
     * move right
     * @param position
     */
    @Override
    public void moveR(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x+1, y, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
    }


    @Override
    public IDiamond getDiamond() throws IOException {
        return new Diamond();
    }
}

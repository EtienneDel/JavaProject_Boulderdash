package model;
/**
 * <h1>the Diamond class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

public class Diamond extends Tile implements Breakable, Movable {

    /**
     * constructor
     * @param x
     * @param y
     */
    public Diamond(int x, int y) {
        super(x, y);
        setRef(4);
        setWalkable(true);

    }

    /**
     * if the diamond is taken
     */
    @Override
    public void isBreak() {
        setRef(2);
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
        setPosition(position.getPosX(), y++);
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

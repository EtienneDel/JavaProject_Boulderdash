package model;
/**
 * <h1>the Rock class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Rock extends Tile implements Movable {
    /**
     * Constructor
     * @param x
     * @param y
     */
    public Rock(int x, int y) {
        super(x, y);
        setRef(5);
        setWalkable(false);
    }

    /**
     * move up
     * @param position
     */
    @Override
    public void moveU(Position position) {
    }

    /**
     * move Down
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
        int x = position.getPosX();
        setPosition(x--, position.getPosY());
    }

    /**
     * move right
     * @param position
     */
    @Override
    public void moveR(Position position) {
        int x = position.getPosX();
        setPosition(x++, position.getPosY());
    }
}
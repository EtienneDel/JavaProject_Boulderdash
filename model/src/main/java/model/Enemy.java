package model;
/**
 * <h1>the Enemy class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Enemy extends Entitie implements IEnemies {

    /**
     * attributes
     */
    public final static int REF = 7;
    public int lastDirection;

    /**
     * constructor with parameter position of the tile
     *
     * @param x
     * @param y
     */
    public Enemy(int x, int y) {
        super(x, y);
        setWalkable(false);

    }

    /**
     * constructor without parameter
     */
    public Enemy() {
        super();
        setWalkable(false);
    }

    public void moveDown(IPosition position) {
        moveD(position);
        setLastDirection(3);
    }

    public void moveRight(IPosition position) {
        moveR(position);
        setLastDirection(2);
    }

    public void moveUp(IPosition position) {
        moveU(position);
        setLastDirection(1);
    }

    public void moveLeft(IPosition position) {
        moveL(position);
        setLastDirection(0);
    }

    public void setLastDirection(int direction) {
        this.lastDirection = direction;
    }

    @Override
    public int getLastDirection() {
        return lastDirection;
    }
}

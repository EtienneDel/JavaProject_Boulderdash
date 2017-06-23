package model;

import java.io.IOException;

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
    /**
     * The Last direction.
     */
    public int lastDirection = 0;
    private int algo;

    /**
     * constructor with parameter position of the tile
     *
     * @param x the x
     * @param y the y
     * @throws IOException the io exception
     */
    public Enemy(int x, int y) throws IOException {
        super(x, y);
        setWalkable(false);
        this.algo = (int) (Math.random() * 3);
        this.algo = 1;
    }

    /**
     * constructor without parameter
     *
     * @throws IOException the io exception
     */
    public Enemy() throws IOException {
        super();
        setWalkable(false);
        //this.algo = (int)(Math.random() * 3);
        this.algo = 1;
    }

    public void moveDown(IPosition position) {
        moveD(position);
        setLastDirection(3);
        setPosition(position.getPosX(), position.getPosY() + 1);
    }

    public void moveRight(IPosition position) {
        moveR(position);
        setLastDirection(2);
        setPosition(position.getPosX() + 1, position.getPosY());
    }

    public void moveUp(IPosition position) {
        moveU(position);
        setLastDirection(1);
        setPosition(position.getPosX(), position.getPosY() - 1);
    }

    public void moveLeft(IPosition position) {
        moveL(position);
        setLastDirection(0);
        setPosition(position.getPosX() - 1, position.getPosY());
    }

    public int getAlgo() {
        return algo;
    }

    @Override
    public int getLastDirection() {
        return lastDirection;
    }

    /**
     * Sets last direction.
     *
     * @param direction the direction
     */
    public void setLastDirection(int direction) {
        this.lastDirection = direction;
    }
}

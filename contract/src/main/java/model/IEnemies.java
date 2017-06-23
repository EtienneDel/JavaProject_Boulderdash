package model;

/**
 * The Interface IEnemies allows to get the movements of the enemies in the controller.
 */
public interface IEnemies extends Movable {
    /**
     * Gets last direction.
     *
     * @return the last direction
     */
    int getLastDirection();

    /**
     * Gets position.
     *
     * @return the position
     */
    IPosition getPosition();

    /**
     * Sets position.
     *
     * @param x the x
     * @param y the y
     */
    void setPosition(int x, int y);

    /**
     * Move down.
     *
     * @param position the position
     */
    void moveDown(IPosition position);

    /**
     * Move up.
     *
     * @param position the position
     */
    void moveUp(IPosition position);

    /**
     * Move right.
     *
     * @param position the position
     */
    void moveRight(IPosition position);

    /**
     * Move left.
     *
     * @param position the position
     */
    void moveLeft(IPosition position);

    /**
     * Gets algo.
     *
     * @return the algo
     */
    int getAlgo();
}

package model;

/**
 * The Interface Movable provides movement for all the tiles to the controller.
 */
public interface Movable {

    /**
     * Move u.
     *
     * @param position the position
     */
    void moveU(IPosition position);

    /**
     * Move d.
     *
     * @param position the position
     */
    void moveD(IPosition position);

    /**
     * Move l.
     *
     * @param position the position
     */
    void moveL(IPosition position);

    /**
     * Move r.
     *
     * @param position the position
     */
    void moveR(IPosition position);
}

package model;

/**
 * <h1>the Movable interface</h1>
 *
 * @author Paul Brouet
 * @version 1.0
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

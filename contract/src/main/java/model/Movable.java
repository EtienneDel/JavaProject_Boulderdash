package model;

/**
 * <h1>the Movable interface</h1>
 *
 * @author  Paul Brouet
 * @version 1.0
 */
public interface Movable {

    void moveU(IPosition position);
    void moveD(IPosition position);
    void moveL(IPosition position);
    void moveR(IPosition position);
}

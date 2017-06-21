package model;

/**
 * <h1>the Movable interface</h1>
 *
 * @author  Paul Brouet
 * @version 1.0
 */
public interface Movable {

    public void moveU(IPosition position);
    public void moveD(IPosition position);
    public void moveL(IPosition position);
    public void moveR(IPosition position);
}

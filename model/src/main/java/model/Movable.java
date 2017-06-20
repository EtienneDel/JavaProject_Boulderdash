package model;

/**
 * <h1>the Movable interface</h1>
 *
 * @author  Paul Brouet
 * @version 1.0
 */
public interface Movable {

    public void moveU(Position position);
    public void moveD(Position position);
    public void moveL(Position position);
    public void moveR(Position position);
}

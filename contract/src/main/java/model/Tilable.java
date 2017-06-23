package model;

/**
 * The Interface Tilable provide a position and a reference for the tiles to the controller
 */
public interface Tilable {

    /**
     * Gets ref.
     *
     * @return the ref
     */
    int getRef();

    /**
     * Sets position.
     *
     * @param position the position
     */
    void setPosition(IPosition position);

    /**
     * Gets .
     *
     * @return the
     */
    Boolean getwlakable();

}

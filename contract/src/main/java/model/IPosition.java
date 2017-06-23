package model;

/**
 * Created by Julien on 21/06/2017.
 */
public interface IPosition {
    /**
     * Gets position.
     *
     * @param x the x
     * @param y the y
     * @return the position
     */
    IPosition getPosition(int x, int y);

    /**
     * Sets position.
     *
     * @param x the x
     * @param y the y
     */
    void setPosition(int x, int y);

    /**
     * Gets pos x.
     *
     * @return the pos x
     */
    int getPosX();

    /**
     * Gets pos y.
     *
     * @return the pos y
     */
    int getPosY();
}

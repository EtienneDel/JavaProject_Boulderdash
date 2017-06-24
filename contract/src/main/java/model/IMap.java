package model;

import java.io.IOException;
import java.util.Observer;

/**
 * The Interface IMap provides methods to change the reference numbers in the map.
 */
public interface IMap {
    /**
     * Gets the map.
     *
     * @return the the map
     * @throws IOException the io exception
     */
    IMap getTheMap() throws IOException;

    /**
     * Add observer.
     *
     * @param o the o
     */
    void addObserver(Observer o);

    /**
     * Gets char by pos.
     *
     * @param x the x
     * @param y the y
     * @return the char by pos
     */
    char getCharByPos(int x, int y);

    /**
     * Sets char by pos.
     *
     * @param x     the x
     * @param y     the y
     * @param chare the chare
     */
    void setCharByPos(int x, int y, char chare);

    /**
     * Gets tile by pos.
     *
     * @param position the position
     * @return the tile by pos
     */
    Tilable getTileByPos(IPosition position);

    /**
     * Is hero present boolean.
     *
     * @return the boolean
     */
    boolean isHeroPresent();

}

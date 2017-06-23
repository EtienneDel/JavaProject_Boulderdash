package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Interface IModel regroups the map attributes.
 */
public interface IModel {

    /**
     * Gets map width.
     *
     * @return the map width
     */
    int getMap_width();

    /**
     * Gets map height.
     *
     * @return map height
     */
    int getMap_height();


    /**
     * Get tab map char [ ] [ ].
     *
     * @return the char [ ] [ ]
     */
    char[][] getTab_map();

    /**
     * Sets tab map.
     *
     * @param tab_map the tab map
     */
    void setTab_map(char[][] tab_map);

    /**
     * Gets assets.
     *
     * @return the assets
     */
    Assetable getAssets();

    /**
     * Gets the map.
     *
     * @return the the map
     * @throws IOException the io exception
     */
    IMap getTheMap() throws IOException;

    /**
     * Gets position.
     *
     * @param x the x
     * @param y the y
     * @return the position
     */
    IPosition getPosition(int x, int y);

    /**
     * Gets rock.
     *
     * @return the rock
     * @throws IOException the io exception
     */
    IRock getRock() throws IOException;

    /**
     * Gets diamond.
     *
     * @return the diamond
     * @throws IOException the io exception
     */
    IDiamond getDiamond() throws IOException;

    /**
     * Gets diamonds.
     *
     * @return the diamonds
     */
    int getDiamonds();

    /**
     * Sets the character a.
     *
     * @param x the x
     * @param y the y
     * @return the the character a
     * @throws IOException the io exception
     */
    ICharacter setTheCharacterA(int x, int y) throws IOException;

    /**
     * Gets the character a.
     *
     * @return the the character a
     * @throws IOException the io exception
     */
    ICharacter getTheCharacterA() throws IOException;

    /**
     * Create enemy list array list.
     *
     * @return the array list
     * @throws IOException the io exception
     */
    ArrayList<IEnemies> createEnemyList() throws IOException;

}

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
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleById(int id) throws SQLException;

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleByName(String name) throws SQLException;

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    List<Example> getAllExamples() throws SQLException;

    int getMap_width();

    int getMap_height();

    char[][] getTab_map();

    void setTab_map(char[][] tab_map);

    Assetable getAssets();

    IMap getTheMap() throws IOException;

    IPosition getPosition(int x, int y);

    IRock getRock() throws IOException;

    IDiamond getDiamond() throws IOException;
    
    int getDiamonds();

    ICharacter setTheCharacterA(int x, int y) throws IOException;

    ICharacter getTheCharacterA() throws IOException;

    ArrayList<IEnemies> createEnemyList() throws IOException;

}

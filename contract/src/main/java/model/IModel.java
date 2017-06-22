package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
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



    public int getMap_width();

    public int getMap_height();

    public char[][] getTab_map();

    public void setTab_map(char[][] tab_map);

    Assetable getAssets();

    IMap getTheMap() throws IOException;

    IPosition getPosition(int x, int y);

    IRock getRock() throws IOException;

    IDiamond getDiamond() throws IOException;

    ICharacter setTheCharacterA(int x, int y) throws IOException;

    ICharacter getTheCharacterA() throws IOException;

}

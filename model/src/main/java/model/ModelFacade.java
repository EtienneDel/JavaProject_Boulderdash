package model;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;
import model.dao.MapDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {

    private Map map;
    private MapDAO mapDAO = null;
    private int map_width, map_height;
    private char tab_map[][];

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade(String nomMap) throws IOException, SQLException {

        mapDAO = MapDAO.setMapDAO(nomMap);
        while(mapDAO == null);
        map = Map.getMap();
        String str_map;

        str_map = mapDAO.readMap(nomMap);
        map_width = mapDAO.readSize(nomMap,"width");
        map_height = mapDAO.readSize(nomMap,"heigth");
        tab_map = mapDAO.putMapInTable(str_map);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }

    public int getMap_width() {
        return map_width;
    }

    public int getMap_height() {
        return map_height;
    }

    public char[][] getTab_map() {
        return tab_map;
    }

    public void setTab_map(char[][] tab_map) {
        this.tab_map = tab_map;
    }
}

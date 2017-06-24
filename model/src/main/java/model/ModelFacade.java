package model;

import model.dao.MapDAO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observer;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean -Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel, IMap {

    private Map map;
    private MapDAO mapDAO = null;
    private int map_width, map_height;
    private char tab_map[][];

    /**
     * Instantiates a new model facade.
     *
     * @param nomMap the nom map
     * @throws IOException  the io exception
     * @throws SQLException the sql exception
     */
    public ModelFacade(String nomMap) throws IOException, SQLException {

        mapDAO = MapDAO.setMapDAO(nomMap);
        map = Map.getMap();
        String str_map;

        str_map = mapDAO.readMap(nomMap);
        map_width = mapDAO.getMap_Width();
        map_height = mapDAO.getMap_Heigth();
        tab_map = mapDAO.putMapInTable(str_map);
    }

    /**
     * differents getter and setter
     *
     * @return
     */
    public int getMap_width() {
        return map_width;
    }

    @Override
    public BufferedImage getGameOver() {
        return null;
    }

    public int getMap_height() {
        return map_height;
    }

    public char[][] getTab_map() {
        tab_map = map.getTablemap();
        return tab_map;
    }

    public void setTab_map(char[][] tab_map) {
        this.tab_map = tab_map;
    }

    @Override
    public Assetable getAssets() {

        Assets assets = null;
        try {
            assets = new Assets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assets;
    }

    @Override
    public IMap getTheMap() throws IOException {
        return Map.getMap();
    }

    @Override
    public void addObserver(Observer o) {
        map.addObserver(o);
    }

    @Override
    public IRock getRock() throws IOException {
        return new Rock();
    }

    @Override
    public IDiamond getDiamond() throws IOException {
        return new Diamond();
    }

    @Override
    public ICharacter setTheCharacterA(int x, int y) throws IOException {
        return Character.setTheCharacter(x, y);
    }

    @Override
    public ICharacter getTheCharacterA() throws IOException {
        return Character.getTheCharacter();
    }

    @Override
    public ArrayList<IEnemies> createEnemyList() throws IOException {
        return map.createEnemyList();
    }

    @Override
    public IPosition getPosition(int x, int y) {
        return new Position(x, y);
    }

    @Override
    public char getCharByPos(int x, int y) {
        return 0;
    }

    @Override
    public void setCharByPos(int x, int y, char chare) {

    }

    @Override
    public Tilable getTileByPos(IPosition position) {
        return null;
    }

    @Override
    public int getDiamonds() {
        // TODO Auto-generated method stub
        return mapDAO.getdiamonds();
    }
}

package model;

import model.dao.MapDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>the Map class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Map extends java.util.Observable implements IMap {

    /**
     * attributes
     */
    private static Map instance = null;
    private MapDAO mapDAO = null;
    private ArrayList<IEnemies> enemyList = new ArrayList<>();
    private char tablemap[][];

    /**
     * constructor without any parameter
     */
    private Map() throws IOException {

        this.mapDAO = MapDAO.getMapDAO();

        this.tablemap = mapDAO.getTablemap();

    }

    /**
     * get the instance of the map
     *
     * @return map map
     * @throws IOException the io exception
     */
    public static Map getMap() throws IOException {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    /**
     * instantiate the Hashmap and fill it
     *
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<IEnemies> createEnemyList() throws IOException {
        if(this.enemyList.size() > 0)
            return enemyList;
        int y = mapDAO.getMap_Heigth();
        int x = mapDAO.getMap_Width();
        int e, i;

        for (i = 0; i < y; i++) {
            for (e = 0; e < x; e++) {
                if (tablemap[i][e] == '7')
                    enemyList.add(new Enemy(i, e));
            }
        }
        return enemyList;
    }

    /**
     * Get tablemap char [ ] [ ].
     *
     * @return the char [ ] [ ]
     */
    public char[][] getTablemap() {
        return tablemap;
    }

    public IMap getTheMap() throws IOException {
        return null;
    }

    /**
     * get a char at the specified position
     *
     * @param x
     * @param y
     * @return
     */
    public char getCharByPos(int x, int y) {
        return tablemap[x][y];
    }

    public void setTablemap(char[][] tablemap) {
        this.tablemap = tablemap;
    }

    @Override
    public Tilable getTileByPos(IPosition position) {
        return null;
    }

    /**
     * set a specified char of the table at the position specified
     *
     * @param x
     * @param y
     * @param chare
     */
    @Override
    public void setCharByPos(int x, int y, char chare) {
        tablemap[x][y] = chare;
        setChanged();
        notifyObservers();
    }

}
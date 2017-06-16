package model;

import model.dao.MapDAO;

import java.util.ArrayList;
/**
 * <h1>the Map class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Map {

    private Tile tile;
    private MapDAO mapDAO;
    private ArrayList<Tile> tiles;

    /**
     * constructor
     * @param tile
     * @param mapDAO
     */
    public Map(Tile tile, MapDAO mapDAO) {
        this.tile = tile;
        this.mapDAO = mapDAO;


    }
}

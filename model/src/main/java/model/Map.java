package model;

import model.dao.MapDAO;

public class Map {

    private Tile tile;
    private MapDAO mapDAO;

    public Map(Tile tile, MapDAO mapDAO){
        this.tile = tile;
        this.mapDAO = mapDAO;

    }
}

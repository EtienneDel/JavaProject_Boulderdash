package model;

import model.dao.MapDAO;

import java.util.ArrayList;

public class Map {

    private Tile tile;
    private MapDAO mapDAO;
    private ArrayList<Tile> tiles;

    public Map(Tile tile, MapDAO mapDAO) {
        this.tile = tile;
        this.mapDAO = mapDAO;

    }
}

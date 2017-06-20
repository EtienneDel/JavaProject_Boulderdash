package model;

import model.dao.MapDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>the Map class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Map {


    private static Map instance = null;
    private MapDAO mapDAO;
    private HashMap<Tile, Integer> tiles;
    private char tablemap[][];

    /**
     * constructor
     *
     * @param mapDAO
     */
    private Map(MapDAO mapDAO) throws IOException {

        this.mapDAO = mapDAO;
        this.tablemap = mapDAO.getTablemap();
        createTileTable();

    }
    public void createTileTable() throws IOException {
        int x = mapDAO.getMap_Heigth();
        int y = mapDAO.getMap_Width();
        int e,  i;
        Tile tile;


        for ( i = 0; i < x; i++) {
            for (e = 0; e < y; e++) {

                switch (tablemap[i][e]) {

                    case 0:
                        tile = new Dirt(i, e);
                        break;
                    case 1:
                        tile = new Wall(i, e);
                        break;
                    case 2:
                        tile = new Empty(i, e);
                        break;
                    case 3:
                        tile = new BWall(i, e);
                        break;
                    case 4:
                        tile = new Diamond(i, e);
                        break;
                    case 5:
                        tile = new Rock(i, e);
                        break;
                    case 6:
                        tile = new Exit(i, e);
                        break;
                    case 7:
                        tile = new Enemy(i, e);
                        break;
                    case 8:
                        tile = new Character(i, e);
                        break;
                    default:
                        tile = new Empty(i, e);
                        break;
                }

                tiles.put(tile, (int) tablemap[i][e]);

            }
            e = 0;
        }
    }

    public ArrayList<Rock> getListRock() {
        ArrayList<Rock> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == 5) {
                list.add((Rock) k);
            }
        });
        return list;
    }

    public ArrayList<Diamond> getListDiamond() {
        ArrayList<Diamond> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == 5) {
                list.add((Diamond) k);
            }
        });
        return list;
    }

    public ArrayList<Enemy> getListEnemy() {
        ArrayList<Enemy> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == 5) {
                list.add((Enemy) k);
            }
        });
        return list;
    }

    public Tile getTileByPos(Position position) {
        final Tile[] toReturn = new Tile[1];
        tiles.forEach((Tile k, Integer v) -> {
            if(k.getPosition().equals(position)) {
                toReturn[0] = k;
            }
        });

        return toReturn[0];
    }

    public Rock getRockByPos(Position position) {

        return (Rock) getTileByPos(position);
    }

    public Diamond getDiamondByPos(Position position) {

        return (Diamond) getTileByPos(position);
    }

    public static Map getMap(MapDAO mapDAO) throws IOException {
        if (instance == null) {

            instance = new Map(mapDAO);
        }
        return instance;
    }

    public char getCharByPos(int x, int y) throws IOException, SQLException {

        final IModel test = new ModelFacade("map1");
        tablemap = test.getTab_map();
        char c = tablemap[x][y];

        return  c;
    }
}
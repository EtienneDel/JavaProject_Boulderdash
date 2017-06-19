package model;

import model.dao.MapDAO;

import java.io.IOException;
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
        int x = mapDAO.getMap_Heigth();
        int y = mapDAO.getMap_Width();
        int e;
        Tile tile;


        for (int i = 0; i < x; i++) {
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
    public ArrayList<Tile> getList(int ref) {
        ArrayList<Tile> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == ref) {
                list.add(k);
            }
        });
        return list;
    }

    public static Map getMap(MapDAO mapDAO) throws IOException {
        if (instance == null) {

            instance = new Map(mapDAO);
        }
        return instance;
    }

    public char getCharByPos(int x, int y) {

        char[][] tablemap = mapDAO.getTablemap();

        return  tablemap[x][y];
    }
}
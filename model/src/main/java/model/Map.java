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
public class Map implements IMap {

    /**
     * attributes
     */
    private static Map instance = null;
    private MapDAO mapDAO = null;
    private HashMap<Tile, Integer> tiles = new HashMap<>();
    private char tablemap[][];

    /**
     * constructor without any parameter
     *
     */
    private Map() throws IOException {

        this.mapDAO = MapDAO.getMapDAO();

        this.tablemap = mapDAO.getTablemap();
        createTileTable();

    }

    /**
     * instantiate the Hashmap and fill it
     * @throws IOException
     */
    public void createTileTable() throws IOException {
        int y = mapDAO.getMap_Heigth();
        int x = mapDAO.getMap_Width();
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
        }
    }

    /**
     * get the list of rocks
     * @return
     */
    public ArrayList<Rock> getListRock() {
        ArrayList<Rock> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == 5) {
                list.add((Rock) k);
            }
        });
        return list;
    }

    /**
     * get the list of all diamonds
     * @return
     */
    public ArrayList<Diamond> getListDiamond() {
        ArrayList<Diamond> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == 5) {
                list.add((Diamond) k);
            }
        });
        return list;
    }

    /**
     * get the list of all enemies
     * @return
     */
    public ArrayList<Enemy> getListEnemy() {
        ArrayList<Enemy> list = new ArrayList<>();
        tiles.forEach((k, v) -> {
            if(v == 5) {
                list.add((Enemy) k);
            }
        });
        return list;
    }

    /**
     * get a tile by his position
     * @param position
     * @return
     */
    public Tile getTileByPos(Position position) {
        final Tile[] toReturn = new Tile[1];
        tiles.forEach((k, v) -> {
            if(k.getPosition().getPosY() == position.getPosY() && k.getPosition().getPosX() == position.getPosX()) {
                toReturn[0] = k;
            }
        });

        return toReturn[0];
    }

    /**
     * get a rock by his position
     * @param position
     * @return
     */
    public Rock getRockByPos(Position position) {

        return (Rock) getTileByPos(position);
    }

    /**
     * get a diamond by his position
     * @param position
     * @return
     */
    public Diamond getDiamondByPos(Position position) {

        return (Diamond) getTileByPos(position);
    }

    public char[][] getTablemap() {
        return tablemap;
    }

    /**
     * get the instance of the map
     * @return
     * @throws IOException
     */
    public static Map getMap() throws IOException {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public IMap getTheMap() throws IOException {
        return null;
    }

    /**
     * get a char at the specified position
     * @param x
     * @param y
     * @return
     */
    public char getCharByPos(int x, int y)  {
        return tablemap[x][y];
    }


    @Override
    public Tilable getTileByPos(IPosition position) {
        return null;
    }

    /**
     * set a specified char of the table at the position specified
     * @param x
     * @param y
     * @param chare
     */
    @Override
    public void setCharByPos(int x, int y, char chare){
        tablemap[x][y]= chare;
    }

    /**
     * getter of the hashmap
     * @return
     */
    public HashMap<Tile, Integer> getTiles() {
        return tiles;
    }
}
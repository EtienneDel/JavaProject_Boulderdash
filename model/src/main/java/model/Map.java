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
        int x = mapDAO.getMap_Heigth();
        int y = mapDAO.getMap_Width();
        int e,  i;
        Tile tile;
        System.out.println(x);
        System.out.println(y);

        for ( i = 0; i < y; i++) {
            for (e = 0; e < x; e++) {
                System.out.println(i + " " + e);
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
        tiles.forEach((Tile k, Integer v) -> {
            if(k.getPosition().equals(position)) {
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

    /**
     * get a char at the specified position
     * @param x
     * @param y
     * @return
     */
    public char getCharByPos(int x, int y)  {

        IModel test = null;
        try {
            test = new ModelFacade("maptest");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        char c = tablemap[x][y];

        return  c;
    }

    /**
     * set a specified char of the table at the position specified
     * @param x
     * @param y
     * @param chare
     */
    public void setCharBypos(int x, int y, char chare){


        IModel test = null;
        try {
            test = new ModelFacade("maptest");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(tablemap[x][y]);
        tablemap[x][y]= chare;
        System.out.println(tablemap[x][y]);


    }

    /**
     * getter of the hashmap
     * @return
     */
    public HashMap<Tile, Integer> getTiles() {
        return tiles;
    }
}
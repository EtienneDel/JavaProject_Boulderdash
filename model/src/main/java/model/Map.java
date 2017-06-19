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


    private MapDAO mapDAO;
    private HashMap<Tile, Integer> tiles;
    private char tablemap[][];

    /**
     * constructor

     * @param mapDAO
     */
    public Map( MapDAO mapDAO) throws IOException {

        this.mapDAO = mapDAO;
        this.tablemap = mapDAO.getTablemap();
        int x = mapDAO.getMap_Heigth();
        int y = mapDAO.getMap_Width();
        int e ;
        Tile tile;


        for(int i =0;i<x; i++){
            for( e=0 ; e<y; e++) {

                switch (tablemap[x][y]) {

                    case 0:
                        tile = new Dirt();
                        break;
                    case 1:
                        tile = new Wall();
                        break;
                    case 2:
                        tile = new Empty();
                        break;
                    case 3:
                        tile = new BWall();
                        break;
                    case 4:
                        tile = new Diamond();
                        break;
                    case 5:
                        tile = new Rock();
                        break;
                    case 6:
                        tile = new Exit();
                        break;
                    case 7:
                        tile = new Enemy();
                        break;
                    case 8:
                        tile = new Character();
                        break;
                    default:
                        tile = new Empty();
                        break;


                }

                tiles.put(tile, (int) tablemap[x][y]);

            }
            e = 0;
        }


    }
    public char getCharByPos(int x, int y) {

        char[][] tablemap = mapDAO.getTablemap();



        return  tablemap[x][y];
    }


    //TODO edit this 
    public static Map getMap() { return null; }
}

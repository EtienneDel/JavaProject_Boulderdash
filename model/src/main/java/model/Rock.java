package model;

import model.dao.MapDAO;

import java.io.IOException;

/**
 * <h1>the Rock class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Rock extends Tile implements Movable, IRock {
    /**
     * attribute
     */
    public final static int REF = 5;
    private Map map = Map.getMap();
    /**
     * Constructor with parameter position of the tile
     * @param x
     * @param y
     */
    public Rock(int x, int y) throws IOException {
        super(x, y);
        setWalkable(false);
    }

    /**
     * constuctor without parameter
     */
    public Rock() throws IOException {
        super();
        setWalkable(false);
    }



    /**
     * move up
     * @param position
     */
    @Override
    public void moveU(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y,'2');
        map.setCharByPos(x, y-1,'5');
    }

    /**
     * move Down
     * @param position
     */
    @Override
    public void moveD(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y+1, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
    }

    /**
     * move left
     * @param position
     */
    @Override
    public void moveL(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x-1, y, map.getCharByPos(x, y));
        if(map.getCharByPos(x+1,y)!='8'){
            map.setCharByPos(x, y,'2');
        }
    }

    /**
     * move right
     * @param position
     */
    @Override
    public void moveR(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x+1, y, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
    }


    @Override
    public IRock getRock() throws IOException {
        return new Rock();
    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }
}
package model;

import java.io.IOException;

/**
 * The type Entitie.
 */
public abstract class Entitie extends Tile implements Movable, IEntities{

    /**
     * attribute
     */
    protected Boolean isAlive;
    private Map map = Map.getMap();

    /**
     * contructor with parameter position of the tile
     *
     * @param x the x
     * @param y the y
     * @throws IOException the io exception
     */
    public Entitie(int x, int y) throws IOException {

        super(x,y);


    }

    /**
     * constructor without parameter
     *
     * @throws IOException the io exception
     */
    public Entitie() throws IOException {

        super();


    }

    /**
     * move up
     * @param position
     */
    @Override
    public void moveU(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y-1, map.getCharByPos(x, y));
        map.setCharByPos(x, y,'2');
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
        map.setCharByPos(x, y,'2');
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

}

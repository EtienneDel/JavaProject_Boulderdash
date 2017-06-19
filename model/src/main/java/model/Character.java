package model;
/**
 * <h1>ths Character class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

public class Character extends Entitie  {

    public final static int REF = 8;
    /**
     * constructor
     * @param x
     * @param y
     */
    public Character(int x, int y) {
        super(x, y);
        setWalkable(false);


    }
    public Character() {
        super();
        setWalkable(false);


    }
}

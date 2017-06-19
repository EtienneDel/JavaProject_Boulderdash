package model;
/**
 * <h1>ths Character class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

public class Character extends Entitie  {
    /**
     * constructor
     * @param x
     * @param y
     */
    public Character(int x, int y) {
        super(x, y);
        setWalkable(false);


    }
}

package model;

/**
 * <h1>the position class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Position {

    private int posX;
    private int posY;

    /**
     * constructor
     *
     * @param x
     * @param y
     */
    public Position(int x, int y) {

        this.posX = x;
        this.posY = y;

    }

    /**
     * getter PosX
     *
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     * setter posX
     *
     * @param posX
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * getter posY
     *
     * @return
     */
    public int getPosY() {
        return posY;
    }

    /**
     * setter posY
     *
     * @param posY
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
}

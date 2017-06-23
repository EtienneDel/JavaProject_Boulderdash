package model;

/**
 * <h1>the position class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Position implements IPosition {

    /**
     * attributes
     */
    private int posX;
    private int posY;

    /**
     * constructor with parameter position
     *
     * @param x the x
     * @param y the y
     */
    public Position(int x, int y) {

        this.posX = x;
        this.posY = y;

    }

    /**
     * Instantiates a new Position.
     *
     * @param position the position
     */
    public Position(Position position) {
        this.posX = position.getPosX();
        this.posY = position.getPosY();
    }

    /**
     * getter PosX
     *
     * @return
     */
    @Override
    public int getPosX() {
        return posX;
    }

    /**
     * setter posX
     *
     * @param posX the pos x
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * getter posY
     *
     * @return
     */
    @Override
    public int getPosY() {
        return posY;
    }

    /**
     * setter posY
     *
     * @param posY the pos y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public void setPosition(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public IPosition getPosition(int x, int y) {
        return new Position(x, y);
    }

}

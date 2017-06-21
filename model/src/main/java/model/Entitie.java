package model;

public abstract class Entitie extends Tile implements Movable {

    /**
     * attribute
     */
    protected Boolean isAlive;

    /**
     * contructor with parameter position of the tile
     * @param x
     * @param y
     */
    public Entitie(int x, int y) {

        super(x,y);


    }

    /**
     * constructor without parameter
     */
    public Entitie() {

        super();


    }

    /**
     * move up
     * @param position
     */
    @Override
    public void moveU(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y--);
    }

    /**
     * move down
     * @param position
     */
    @Override
    public void moveD(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y++);
    }

    /**
     * move left
     * @param position
     */
    @Override
    public void moveL(Position position) {
        int x = position.getPosX();
        setPosition(x--, position.getPosY());
    }

    /**
     * move right
     * @param position
     */
    @Override
    public void moveR(Position position) {
        int x = position.getPosX();
        setPosition(x++, position.getPosY());
    }

}

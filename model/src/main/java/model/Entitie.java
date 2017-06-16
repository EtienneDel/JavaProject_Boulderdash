package model;

public class Entitie extends Tile implements Movable{

    protected Boolean isAlive;

    public Entitie(int x, int y) {
        super(x, y);
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

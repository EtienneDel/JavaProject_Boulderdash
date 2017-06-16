package model;

public class Enemy extends Entitie implements Movable {

    public Enemy(int x, int y) {
        super(x, y);
        setRef(7);

    }

    @Override
    public void moveU(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y--);
    }

    @Override
    public void moveD(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y++);
    }

    @Override
    public void moveL(Position position) {
        int x = position.getPosX();
        setPosition(x--, position.getPosY());
    }

    @Override
    public void moveR(Position position) {
        int x = position.getPosX();
        setPosition(x++, position.getPosY());
    }
}

package model;

public class Diamond extends Tile implements Breakable, Movable {

    public Diamond(int x, int y) {
        super(x, y);
        setRef(4);
        setWalkable(true);

    }


    @Override
    public void isBreak() {
        setRef(2);
    }

    @Override
    public void moveU(Position position) {
    }

    @Override
    public void moveD(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y++);
    }

    @Override
    public void moveL(Position position) {
    }

    @Override
    public void moveR(Position position) {
    }
}

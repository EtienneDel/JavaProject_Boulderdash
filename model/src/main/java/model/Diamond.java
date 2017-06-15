package model;

public class Diamond extends Tile implements Breakable, Movable{

    public Diamond(int x, int y){
        super(x,y);

    }

    

    @Override
    public void isBreak() {

        setRef(2);

    }

    @Override
    public void moveD(Position position) {

    }
}

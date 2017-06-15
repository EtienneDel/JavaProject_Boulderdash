package model;

public class Diamond extends Tile implements Breakable, Movable{

    public Diamond(int x, int y){
        super(x,y);

    }

    @Override
    public void move() {



    }

    @Override
    public void isBreak() {

        setRef(2);

    }
}

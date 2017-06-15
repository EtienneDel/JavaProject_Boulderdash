package model;

public class Dirt extends Tile implements Breakable{

    public Dirt(int x, int y){
        super(x,y);

    }

    @Override
    public void isBreak() {

        setRef(2);
    }
}

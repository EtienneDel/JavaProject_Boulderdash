package model;

public class Rock extends Tile implements Movable{

    public Rock(int x,int y){
        super(x,y);

    }

    @Override
    public void moveD(Position position) {

        int y = position.getPosY();

        setPosition(position.getPosX(), y++);

    }

}

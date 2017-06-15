package model;

public class Rock extends Tile implements Movable{

    public Rock(int x,int y){
        super(x,y);
        setRef(5);

    }

    @Override
    public void moveD(Position position) {

        int y = position.getPosY();

        setPosition(position.getPosX(), y++);

    }



}

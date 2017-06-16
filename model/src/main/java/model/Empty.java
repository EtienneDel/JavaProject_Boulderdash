package model;

public class Empty extends Tile {

    public Empty(int x, int y) {

        super(x, y);
        setRef(2);
        setWalkable(true);

    }
}

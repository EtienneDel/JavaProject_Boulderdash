package model;

import javax.swing.*;

public class Tile {

    protected static int WIDTH = 16;
    protected static int HEIGHT = 16;
    private Position position;
    private ImageIcon img;
    private int ref;
    private boolean isWalkable = true;

    public Tile(int x, int y) {
        position = new Position(x, y);
        setRef(2);
        setWalkable(true);

    }

    //TODO revoir cette fonction
    public int getRefByPos(int x, int y) {
        return Integer.parseInt(null);
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setPosition(int x, int y) {
        position.setPosX(x);
        position.setPosY(y);
    }

    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }
}
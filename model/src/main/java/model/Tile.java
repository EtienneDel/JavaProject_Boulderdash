package model;

import javax.swing.*;

public class Tile {

    protected static int WIDTH = 16;
    protected static int HEIGHT = 16;
    private Position position;
    private ImageIcon img;
    private int ref;

    public Tile(int x, int y) {
        position = new Position(x, y);
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
}
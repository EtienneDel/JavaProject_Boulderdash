package model;

import java.awt.*;

public class Tile {

    protected static int WIDTH = 16;
    protected static int HEIGHT = 16;
    private Position position;
    private Image img;
    private int ref;

    public Tile(int x, int y){
        
        position = new Position(x,y);

    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getRefByPos(int x, int y){


        return Integer.parseInt(null);
    }

    public int getRef() {
        return ref;
    }
}

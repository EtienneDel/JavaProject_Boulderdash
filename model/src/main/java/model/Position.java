package model;

public class Position {

    private int posX;
    private int posY;

    public Position(int x, int y){

        this.posX = x;
        this.posY = y;

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}

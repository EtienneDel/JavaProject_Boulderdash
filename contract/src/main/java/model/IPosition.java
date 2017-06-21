package model;

/**
 * Created by Julien on 21/06/2017.
 */
public interface IPosition {
    IPosition getPosition(int x, int y);
    void setPosition(int x, int y);
    int getPosX();
    int getPosY();
}

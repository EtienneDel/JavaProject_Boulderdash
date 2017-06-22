package model;

/**
 * Created by Julien on 22/06/2017.
 */
public interface IEnemies extends Movable{
    int getLastDirection();
    IPosition getPosition();

    void moveDown(IPosition position);
    void moveUp(IPosition position);
    void moveRight(IPosition position);
    void moveLeft(IPosition position);
}

package model;

/**
 * Created by Julien on 21/06/2017.
 */
public interface IEntities extends Tilable{
    void moveD(IPosition position);
    void moveL(IPosition position);
    void moveR(IPosition position);
    void moveU(IPosition position);
}

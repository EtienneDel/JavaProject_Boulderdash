package model;

import java.io.IOException;
import java.util.Observer;

/**
 * Created by Julien on 20/06/2017.
 */
public interface IMap {
    IMap getTheMap() throws IOException;
    void addObserver(Observer o);

    char getCharByPos(int x, int y);
    void setCharByPos(int x, int y, char chare);
    Tilable getTileByPos(IPosition position);

}

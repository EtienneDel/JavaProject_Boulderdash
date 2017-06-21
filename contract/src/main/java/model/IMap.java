package model;

import java.io.IOException;

/**
 * Created by Julien on 20/06/2017.
 */
public interface IMap {
    IMap getTheMap() throws IOException;

    char getCharByPos(int x, int y);
    void setCharByPos(int x, int y, char chare);
    Tilable getTileByPos(IPosition position);

}

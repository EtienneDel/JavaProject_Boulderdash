package model;

import java.io.IOException;

/**
 * Created by Julien on 20/06/2017.
 */
public interface IRock extends Tilable{
    void moveD(IPosition position);
    void moveL(IPosition position);
    void moveR(IPosition position);
    void moveU(IPosition position);
    Tilable getRock() throws IOException;
}

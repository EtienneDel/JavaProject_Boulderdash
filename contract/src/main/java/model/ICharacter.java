package model;

import java.io.IOException;

/**
 * Created by Etienne on 21/06/2017.
 */
public interface ICharacter extends Tilable{
    void moveD(IPosition position);
    void moveL(IPosition position);
    void moveR(IPosition position);
    void moveU(IPosition position);
    Tilable getCharacter() throws IOException;
    IPosition getPosition();
}

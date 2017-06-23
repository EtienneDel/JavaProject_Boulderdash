package model;

import java.io.IOException;

/**
 * The Interface ICharacter allows to get the movements of the character in the controller.
 */
public interface ICharacter extends Tilable{
    /**
     * Move d.
     *
     * @param position the position
     */
    void moveD(IPosition position);

    /**
     * Move l.
     *
     * @param position the position
     */
    void moveL(IPosition position);

    /**
     * Move r.
     *
     * @param position the position
     */
    void moveR(IPosition position);

    /**
     * Move u.
     *
     * @param position the position
     */
    void moveU(IPosition position);

    /**
     * Gets character.
     *
     * @return the character
     * @throws IOException the io exception
     */
    Tilable getCharacter() throws IOException;

    /**
     * Gets position.
     *
     * @return the position
     */
    IPosition getPosition();
}

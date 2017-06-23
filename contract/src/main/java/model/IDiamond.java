package model;

import java.io.IOException;

/**
 * The Interface IDiamond allows to get the movements of the diamonds in the controller.
 */
public interface IDiamond extends Tilable {
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
     * Gets diamond.
     *
     * @return the diamond
     * @throws IOException the io exception
     */
    Tilable getDiamond() throws IOException;
}

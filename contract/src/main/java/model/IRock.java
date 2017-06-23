package model;

import java.io.IOException;

/**
 * The Interface IRock allows to get the movements of the rocks in the controller.
 */
public interface IRock extends Tilable {
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
     * Gets rock.
     *
     * @return the rock
     * @throws IOException the io exception
     */
    Tilable getRock() throws IOException;
}

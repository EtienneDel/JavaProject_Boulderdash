package model;

import java.io.IOException;

/**
 * Created by Julien on 21/06/2017.
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

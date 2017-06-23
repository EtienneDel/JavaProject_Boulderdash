package model;

import java.io.IOException;

/**
 * Created by Julien on 20/06/2017.
 */
public interface IRock extends Tilable{
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

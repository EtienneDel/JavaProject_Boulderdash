package controller;

import java.io.IOException;

/**
 * Created by Etienne on 21/06/2017.
 */
public interface OrderPerformerable {

    void orderPerformer(final UserOrderable userOrder) throws IOException;

}

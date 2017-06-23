package controller;

import java.io.IOException;

/**
 * The Interface OrderPerformable use an user order.
 */
public interface OrderPerformerable {

    void orderPerformer(final UserOrderable userOrder) throws IOException;

}

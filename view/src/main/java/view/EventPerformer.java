package view;

import controller.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The Class EventPerformer provides an Order to execute linked with the KeyListener.
 */
public class EventPerformer implements EventPerformerable {

    private OrderPerformerable orderPerformer;
    private UserOrderable userOrder;

    /**
     * Instantiates a new Event performer.
     *
     * @param orderPerformer the order performer
     */
    public EventPerformer(final OrderPerformerable orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
    public EventPerformer() {

    }

    /**
     * Key typed user orderable.
     *
     * @param keyCode the key code
     * @return the user orderable
     */
    public UserOrderable keyTyped(final int keyCode) {

        switch (keyCode) {

            case KeyEvent.VK_UP:
                userOrder = new UserOrder(Order.UP);
                break;
            case KeyEvent.VK_DOWN:
                userOrder = new UserOrder(Order.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                userOrder = new UserOrder(Order.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                userOrder = new UserOrder(Order.RIGHT);
                break;
            default:
                userOrder = null;
        }
        return userOrder;
    }

    @Override
    public void eventPerform(final KeyEvent keyCode) throws IOException {
        final UserOrderable userOrder = this.keyTyped(keyCode.getKeyCode());
        if (userOrder != null) {
            this.orderPerformer.orderPerformer(userOrder);
        }
    }
}

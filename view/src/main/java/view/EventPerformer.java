package view;

import controller.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ASUS on 15/06/2017.
 */
public class EventPerformer implements EventPerformerable, IView {

    private OrderPerformerable orderPerformer;
    private UserOrderable userOrder;

    public EventPerformer(final OrderPerformerable orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

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

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void drawImage(BufferedImage image, int x, int y) {

    }

    @Override
    public void initScore() {

    }

    @Override
    public void setScore(int score) {

    }

    @Override
    public int getScore() {
        return 0;
    }
}

package view;

import controller.Order;
import controller.UserOrder;
import controller.UserOrderable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ASUS on 15/06/2017.
 */
public class EventPerformer implements KeyListener {

    public EventPerformer() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        UserOrderable userOrder;

        switch (e.getKeyCode()) {

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
            case KeyEvent.VK_ESCAPE:
                userOrder = new UserOrder(Order.ESCAPE);
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

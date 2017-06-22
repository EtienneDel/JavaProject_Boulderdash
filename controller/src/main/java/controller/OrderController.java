package controller;

import javafx.beans.Observable;

/**
 * Created by Julien on 22/06/2017.
 */
public class OrderController extends java.util.Observable {
    private Build build;
    public OrderController(Build build) {
        this.build = build;
    }

    public void performOrder(UserOrderable userOrder) {
        int x = build.getPosX();
        int y = build.getPosY();

        switch (userOrder.getOrder()) {
            case UP:
                y += 16;
                break;
            case DOWN:
                y -= 16;
                break;
            case LEFT:
                x += 16;
                break;
            case RIGHT:
                x -= 16;
                break;
        }
        build.setPos(x, y);
        setChanged();
        notifyObservers();
    }
}

package controller;

import model.IModel;
import model.IPosition;
import model.Movable;

import java.io.IOException;

/**
 * Created by Julien on 22/06/2017.
 */
public class OrderController extends java.util.Observable {
    private Build build;
    private CharacterController character;
    private IModel model;
    private IPosition position;
    private int i=1,j=1;
    public OrderController(Build build) {
        this.build = build;
    }

    public void performOrder(UserOrderable userOrder, IModel model) throws IOException {
        int x = build.getPosX();
        int y = build.getPosY();
        this.model = model;
        character = new CharacterController(model, build);
        Movable movable = (Movable) model.getDiamond();
        position = model.getPosition(i,j);

        switch (userOrder.getOrder()) {
            case UP:
                y += 16;
                character.moveUp(movable,position);
                j--;
                break;
            case DOWN:
                y -= 16;
                character.moveDown(movable,position);
                j++;
                break;
            case LEFT:
                x += 16;
                character.moveLeft(movable,position);
                i--;
                break;
            case RIGHT:
                x -= 16;
                character.moveRight(movable,position);
                i++;
                break;
        }
        character.refreshAround(position);
        build.setPos(x, y);
        setChanged();
        notifyObservers();
    }
}

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
    private int collision;

    public void performOrder(UserOrderable userOrder, IModel model) throws IOException {
        int x = build.getPosX();
        int y = build.getPosY();
        this.model = model;
        character = new CharacterController(model, build);
        Movable movable = (Movable) model.getDiamond();
        position = model.getPosition(i,j);


        switch (userOrder.getOrder()) {
            case UP:
                character.moveUp(movable,position);
                collision = character.getColli();
                if(collision != 1){
                    j--;
                    y+=16;
                }
                break;
            case DOWN:

                character.moveDown(movable,position);
                collision = character.getColli();
                if(collision != 1) {
                    j++;
                    y -= 16;
                }
                break;
            case LEFT:

                character.moveLeft(movable,position);
                collision = character.getColli();
                if(collision != 1) {
                    i--;
                    x += 16;
                }
                break;
            case RIGHT:

                character.moveRight(movable,position);
                collision = character.getColli();
                if(collision != 1) {
                    i++;
                    x -= 16;
                }
                break;
        }
        character.refreshAround(position);
        build.setPos(x, y);
        setChanged();
        notifyObservers();
    }
}

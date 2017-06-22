package controller;

import model.IModel;
import model.IPosition;
import model.Movable;
import view.IView;

import java.io.IOException;

/**
 * Created by Julien on 22/06/2017.
 */
public class OrderController extends java.util.Observable {
    private Build build;
    private CharacterController character;
    private IModel model;
    private IView view;
    private IPosition position;
    private int i=1,j=1;
    private int collision;
    private RockController rockController;

    public OrderController(Build build) {
        this.build = build;
    }


    public void performOrder(UserOrderable userOrder, IModel model, IView view) throws IOException {
        int x = build.getPosX();
        int y = build.getPosY();
        this.view = view;
        this.model = model;
        character = new CharacterController(model, build);
        Movable movable = (Movable) model.getDiamond();
        position = model.getPosition(i,j);
        rockController = new RockController(model);


        switch (userOrder.getOrder()) {
            case UP:
                character.moveUp(movable,position);
                collision = character.getColli();
                if(collision == 3){
                view.setScore(view.getScore()+1);
                System.out.println(view.getScore());
                j--;
                y+=16;
                }
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
                /*if(collision ==2){
                    rockController.moveLeft(movable, position);
                    i--;
                    x += 16;
                }*/
                if(collision != 1 && collision !=2) {
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

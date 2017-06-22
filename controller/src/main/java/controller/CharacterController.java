package controller;

import model.*;

import java.io.IOException;

/**
 * Created by Etienne on 21/06/2017.
 */
public class CharacterController implements OrderPerformerable{
protected IMap map;
protected IModel model;
protected Build build;
private IPosition position;

    public CharacterController(IModel model) throws IOException {
        this.map = model.getTheMap();
        this.model = model;

    }

    public void refresh(IPosition position) throws IOException {
        this.position = position;

        if(!(position.getPosX() > 0 && position.getPosY() > 0 && (map.getCharByPos(position.getPosX(), position.getPosY()) == '4') || map.getCharByPos(position.getPosX(), position.getPosY()) == '8'))
            return;

    }

    protected void moveUp(Movable movable, IPosition position) throws IOException {
        movable.moveU(position);
        build.calculateMap();
        refreshAround(position);
    }

    protected void moveDown(Movable movable, IPosition position) throws IOException {
        movable.moveD(position);
        build.calculateMap();
        refreshAround(position);
    }

    protected void moveLeft(Movable movable, IPosition position) throws IOException {
        movable.moveL(position);
        build.calculateMap();
        refreshAround(position);
    }

    protected void moveRight(Movable movable, IPosition position) throws IOException {
        movable.moveR(position);
        build.calculateMap();
        refreshAround(position);
    }

    protected void refreshAround(IPosition position) throws IOException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refresh(model.getPosition(position.getPosX(), position.getPosY()-1));
        refresh(model.getPosition(position.getPosX()-1, position.getPosY()));
        refresh(model.getPosition(position.getPosX()+1, position.getPosY()));
        refresh(model.getPosition(position.getPosX(), position.getPosY()+1));
    }

    @Override
    public void orderPerformer(UserOrderable userOrder) throws IOException {
        Movable movable = (Movable) model.getTheCharacterA();

        switch(userOrder.getOrder()){
            case UP:
                moveUp(movable,position);
                break;
            case DOWN:
                moveDown(movable,position);
                break;
            case LEFT:
                moveLeft(movable,position);
                break;
            case RIGHT:
                moveRight(movable,position);
                break;
        }
    }
}

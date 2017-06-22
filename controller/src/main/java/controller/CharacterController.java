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
private RockController rockController;
private DiamondController diamondController;
private int colli = 0;

    public CharacterController(IModel model, Build build) throws IOException {
        this.map = model.getTheMap();
        this.model = model;
        this.build = build;
        rockController = new RockController(model);
        diamondController = new DiamondController(model);

    }

    public void refresh(IPosition position) throws IOException {
        this.position = position;

        if(!(position.getPosX() > 0 && position.getPosY() > 0 && (map.getCharByPos(position.getPosX(), position.getPosY()) == '4') || map.getCharByPos(position.getPosX(), position.getPosY()) == '8'))
            return;
        switch(map.getCharByPos(position.getPosX(), position.getPosY())){
            case '4':
                diamondController.refresh(position);
                break;
            case '5':
                rockController.refresh(position);
                break;
        }

    }

    protected void moveUp(Movable movable, IPosition position) throws IOException {
        switch(map.getCharByPos(position.getPosX(), position.getPosY()-1)){
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '5':
                colli = 1;
                break;
            default:
                movable.moveU(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    protected void moveDown(Movable movable, IPosition position) throws IOException {
        switch(map.getCharByPos(position.getPosX(), position.getPosY()+1)){
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '5':
                colli = 1;
                break;
            default:
                movable.moveD(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    protected void moveLeft(Movable movable, IPosition position) throws IOException {
        switch(map.getCharByPos(position.getPosX()-1, position.getPosY())){
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '5':
                colli = 1;
                break;
            default:
                movable.moveL(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    protected void moveRight(Movable movable, IPosition position) throws IOException {
        switch(map.getCharByPos(position.getPosX()+1, position.getPosY())){
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '5':
                colli = 1;
                break;
            default:
                movable.moveR(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    protected void refreshAround(IPosition position) throws IOException {

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

    public int getColli() {
        return colli;
    }

    public void setColli(int colli) {
        this.colli = colli;
    }
}

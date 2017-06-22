package controller;

import model.*;

import java.io.IOException;

/**
 * Created by Julien on 16/06/2017.
 */

public class RockController extends DiamondController{

    public RockController(IModel model) throws IOException {
        super(model);
    }

    public void refresh(IPosition position) throws IOException {
        super.refresh(position);

        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()+1);
        char leftTile = map.getCharByPos(position.getPosX()-1, position.getPosY());
        char rightTile = map.getCharByPos(position.getPosX()+1, position.getPosY());
        char bottomLeftTile = map.getCharByPos(position.getPosX()-1, position.getPosY()-1);
        char bottomRightTile = map.getCharByPos(position.getPosX()+1, position.getPosY()-1);

        if(map.getCharByPos(position.getPosX(), position.getPosY()) != '5')
            return;

        Movable movable = (Movable) model.getRock();

        if (leftTile == '2' && (bottomLeftTile == '0' || bottomLeftTile == '2' || bottomLeftTile == '7') && bottomTile == '5')
            moveLeft(movable, position);
        else if (rightTile == '2' && (bottomRightTile == '0' || bottomRightTile == '2' || bottomRightTile == '7') && bottomTile == '5')
            moveRight(movable, position);
    }

    @Override
    protected void moveDown(Movable movable, IPosition position) throws IOException {
        movable.moveR(position);

        refreshAround(position);
    }

    private void moveLeft(Movable movable, IPosition position) throws IOException {
        movable.moveL(position);
        movable.moveD(position);
        refreshAround(position);
    }

    private void moveRight(Movable movable, IPosition position) throws IOException {
        movable.moveR(position);
        movable.moveD(position);
        refreshAround(position);
    }

}


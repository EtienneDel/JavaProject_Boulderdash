package controller;

import model.*;

import java.io.IOException;

/**
 * Created by Julien on 16/06/2017.
 */

public class RockController extends DiamondController{

    public RockController(IModel model, Build build) throws IOException {
        super(model, build);
    }

    public void refresh(IPosition position) throws IOException {
        super.refresh(position);

        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()+1);
        char leftTile = map.getCharByPos(position.getPosX()-1, position.getPosY());
        char rightTile = map.getCharByPos(position.getPosX()+1, position.getPosY());
        char bottomLeftTile = map.getCharByPos(position.getPosX()-1, position.getPosY()+1);
        char bottomRightTile = map.getCharByPos(position.getPosX()+1, position.getPosY()+1);

        if(map.getCharByPos(position.getPosX(), position.getPosY()) != '5')
            return;

        Movable movable = (Movable) model.getRock();
        System.out.println(bottomRightTile + " " + bottomLeftTile);
        if (leftTile == '2' && (bottomLeftTile == '3' || bottomLeftTile == '2' || bottomLeftTile == '7') && bottomTile == '5')
            moveLeft(movable, position);
        else if (rightTile == '2' && (bottomRightTile == '3' || bottomRightTile == '2' || bottomRightTile == '7') && bottomTile == '5')
            moveRight(movable, position);
    }

    @Override
    protected void moveDown(Movable movable, IPosition position) throws IOException {
        movable.moveD(position);
        build.calculateMap();
        refreshAround(position);
    }

    private void moveLeft(Movable movable, IPosition position) throws IOException {
        movable.moveL(position);
        build.calculateMap();
        movable.moveD(model.getPosition(position.getPosX()-1, position.getPosY()));
        build.calculateMap();
        refreshAround(position);
    }

    private void moveRight(Movable movable, IPosition position) throws IOException {
        movable.moveR(position);
        build.calculateMap();
        movable.moveD(model.getPosition(position.getPosX()+1, position.getPosY()));
        build.calculateMap();
        refreshAround(position);
    }

}


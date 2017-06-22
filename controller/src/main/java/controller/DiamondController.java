package controller;

import model.*;

import java.io.IOException;



/**
 * Created by Julien on 17/06/2017.
 */

public class DiamondController {
    protected IMap map;
    protected IModel model;

    public DiamondController(IModel model) throws IOException {
        this.map = model.getTheMap();
        this.model = model;
    }

    public void refresh(IPosition position) throws IOException {

        if(!(position.getPosX() > 0 && position.getPosY() > 0 && map.getCharByPos(position.getPosX(), position.getPosY()) == '4'))
            return;

        Movable movable = (Movable) model.getDiamond();
        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()+1);

        if (bottomTile == '7')//monstre
            explode(true, position);
        else if (bottomTile == '0')//bloc cassable
            explode(false, position);
        else if (bottomTile == '2')//vide
            moveDown(movable, position);

}

    protected void moveDown(Movable movable, IPosition position) throws IOException {
        movable.moveD(position);

        refreshAround(position);
    }

    protected void refreshAround(IPosition position) throws IOException {
        refresh(model.getPosition(position.getPosX(), position.getPosY()-1));
        refresh(model.getPosition(position.getPosX()-1, position.getPosY()));
        refresh(model.getPosition(position.getPosX()+1, position.getPosY()));
        refresh(model.getPosition(position.getPosX(), position.getPosY()+1));
    }

    protected void explode(boolean diamondShower, IPosition position) {

    }
}


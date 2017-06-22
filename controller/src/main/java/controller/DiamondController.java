package controller;

import model.*;

import java.io.IOException;



/**
 * Created by Julien on 17/06/2017.
 */

public class DiamondController {
    protected IMap map;
    protected IModel model;

    public DiamondController(IModel model) throws IOException {//todo remove build -- debug
        this.map = model.getTheMap();
        this.model = model;
    }

    public void refresh(IPosition position) throws IOException {
        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()+1);

        if(!(position.getPosX() > 0 && position.getPosY() > 0 && (map.getCharByPos(position.getPosX(), position.getPosY()) == '4') || map.getCharByPos(position.getPosX(), position.getPosY()) == '5'))
            return;

        Movable movable = (Movable) model.getDiamond();

        if (bottomTile == '7')//monstre
            explode(true, position);
        else if (bottomTile == '2')//vide
            moveDown(movable, position);

}

    protected void moveDown(Movable movable, IPosition position) throws IOException {
        movable.moveD(position);
        //build.calculateMap();
        refreshAround(position);
    }

    protected void refreshAround(IPosition position) throws IOException {
        //todo refresh toutes les 0.5s si possibilitées de bouger sauf coté qui bouge en premier

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

    protected void explode(boolean diamondShower, IPosition position) {
        position.setPosition(position.getPosX(), position.getPosY()+1);
        if(diamondShower)
            for(int i=-1; i<2;i++)
                for(int j=-1; j<2;j++)
                    map.setCharByPos(position.getPosX()+i,position.getPosY()+j, '4' );
        else
            for(int i=-1; i<2;i++)
                for(int j=-1; j<2;j++)
                    map.setCharByPos(position.getPosX()+i,position.getPosY()+j, '2' );
    }
}


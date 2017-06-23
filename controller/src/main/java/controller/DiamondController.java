package controller;

import model.IMap;
import model.IModel;
import model.IPosition;
import model.Movable;

import java.io.IOException;


/**
 * The Class DiamondController provides movement for the diamonds.
 */
public class DiamondController {
    /**
     * The Map.
     */
    protected IMap map;
    /**
     * The Model.
     */
    protected IModel model;

    /**
     * Instantiates a new Diamond controller.
     *
     * @param model the model
     * @throws IOException the io exception
     */
    public DiamondController(IModel model) throws IOException {//todo remove build -- debug
        this.map = model.getTheMap();
        this.model = model;
    }

    /**
     * Refresh.
     *
     * @param position the position
     * @throws IOException the io exception
     */
    public void refresh(IPosition position) throws IOException {
        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY() + 1);

        if (!(position.getPosX() > 0 && position.getPosY() > 0 && (map.getCharByPos(position.getPosX(), position.getPosY()) == '4') || map.getCharByPos(position.getPosX(), position.getPosY()) == '5'))
            return;

        Movable movable = (Movable) model.getDiamond();

        if (bottomTile == '7')//monstre
            explode(true, position);
        else if (bottomTile == '2')//vide
            moveDown(movable, position);

    }

    /**
     * Move down.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    protected void moveDown(Movable movable, IPosition position) throws IOException {
        movable.moveD(position);
        refreshAround(position);
    }

    /**
     * Refresh around.
     *
     * @param position the position
     * @throws IOException the io exception
     */
    protected void refreshAround(IPosition position) throws IOException {
        //todo refresh toutes les 0.5s si possibilitées de bouger sauf coté qui bouge en premier

        refresh(model.getPosition(position.getPosX(), position.getPosY() - 1));
        refresh(model.getPosition(position.getPosX() - 1, position.getPosY()));
        refresh(model.getPosition(position.getPosX() + 1, position.getPosY()));
        refresh(model.getPosition(position.getPosX(), position.getPosY() + 1));
    }

    /**
     * Explode.
     *
     * @param diamondShower the diamond shower
     * @param position      the position
     */
    protected void explode(boolean diamondShower, IPosition position) {
        position.setPosition(position.getPosX(), position.getPosY() + 1);
        if (diamondShower)
            for (int i = -1; i < 2; i++)
                for (int j = -1; j < 2; j++)
                    map.setCharByPos(position.getPosX() + i, position.getPosY() + j, '4');
        else
            for (int i = -1; i < 2; i++)
                for (int j = -1; j < 2; j++)
                    map.setCharByPos(position.getPosX() + i, position.getPosY() + j, '2');
    }
}


package controller;

import model.IModel;
import model.IPosition;
import model.Movable;

import java.io.IOException;

/**
 * The Class RockController provides movement for the rocks.
 */
public class RockController extends DiamondController {

    /**
     * Instantiates a new Rock controller.
     *
     * @param model the model
     * @throws IOException the io exception
     */
    public RockController(IModel model) throws IOException {
        super(model);
    }

    /**
     * Refresh.
     *
     * @param position the position
     * @throws IOException
     */
    public void refresh(IPosition position) throws IOException {

        super.refresh(position);

        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY() + 1);
        char leftTile = map.getCharByPos(position.getPosX() - 1, position.getPosY());
        char rightTile = map.getCharByPos(position.getPosX() + 1, position.getPosY());
        char bottomLeftTile = map.getCharByPos(position.getPosX() - 1, position.getPosY() + 1);
        char bottomRightTile = map.getCharByPos(position.getPosX() + 1, position.getPosY() + 1);

        if (map.getCharByPos(position.getPosX(), position.getPosY()) != '5')
            return;

        Movable movable = (Movable) model.getRock();

        if (bottomTile == '3')//bloc cassable
            explode(false, position);
        else if (leftTile == '2' && (bottomLeftTile == '3' || bottomLeftTile == '2' || bottomLeftTile == '7') && (bottomTile == '5' || bottomTile == '4'))
        {
            moveLeft(movable, position);
            moveDown(movable, model.getPosition(position.getPosX()-1, position.getPosY()));
        }
        else if (rightTile == '2' && (bottomRightTile == '3' || bottomRightTile == '2' || bottomRightTile == '7') && (bottomTile == '5' || bottomTile == '4'))
        {
            moveRight(movable, position);
            moveDown(movable, model.getPosition(position.getPosX()+1, position.getPosY()));
        }
    }

    @Override
    protected void moveDown(Movable movable, IPosition position) throws IOException {
        if(map.getCharByPos(position.getPosX(), position.getPosY()+1) == '5')
            return;
        movable.moveD(position);
        refreshAround(position);
    }

    /**
     * Move left.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    public void moveLeft(Movable movable, IPosition position) throws IOException {
        movable.moveL(position);
        refreshAround(position);
    }

    /**
     * Move right.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    public void moveRight(Movable movable, IPosition position) throws IOException {
        movable.moveR(position);
        refreshAround(position);
    }

}


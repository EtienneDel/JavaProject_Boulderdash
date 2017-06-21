package controller;

import model.*;

import java.io.IOException;

/**
 * Created by Julien on 16/06/2017.
 */

public class RockController {
    private IMap map;
    private IModel model;

    public RockController(IModel model) throws IOException {
        this.map = model.getTheMap();
        this.model = model;
    }

    public void refresh(IPosition position) throws IOException {
        IRock rock = model.getRock();// = map.getRockByPos(position);
        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()+1);
        char leftTile = map.getCharByPos(position.getPosX()-1, position.getPosY());
        char rightTile = map.getCharByPos(position.getPosX()+1, position.getPosY());
        char bottomLeftTile = map.getCharByPos(position.getPosX()-1, position.getPosY()-1);
        char bottomRightTile = map.getCharByPos(position.getPosX()+1, position.getPosY()-1);

        if (bottomTile == '7')//monstre
            explode(true, position);
        else if (bottomTile == '0')//bloc cassable
            explode(false, position);
        else if (bottomTile == '2')//vide
            moveDown(rock, position);
        else {
            if (leftTile == '2' && (bottomLeftTile == '0' || bottomLeftTile == '2' || bottomLeftTile == '7'))//vide
                rock.moveL(position);
            else {
                if (rightTile == '2' && (bottomRightTile == '0' || bottomRightTile == '2' || bottomRightTile == '7'))//vide
                    rock.moveR(position);
            }
        }

//        position = rock.getPosition();
//        bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()-1);
//        //permet de ré update le caillou si y'a du vide dessous
//        //todo supprimer ?
//        if(bottomTile == '2') {
//            Position finalPosition = position;
//            setTimeout(() -> refresh(finalPosition), 500);
//        }
    }

    private void moveDown(IRock rock, IPosition position) {
        rock.setPosition(position);
        rock.moveD(position);
    }

    private void explode(boolean diamondShower, IPosition position) {

    }

    public void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
}


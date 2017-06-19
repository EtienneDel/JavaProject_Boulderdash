package controller;

import model.Map;
import model.Position;
import model.Rock;
import model.Tile;

import java.util.ArrayList;

/**
 * Created by Julien on 16/06/2017.
 */

public class RockController {

    private ArrayList<Rock> rockList;
    private Map map = Map.getMap();

    public RockController(ArrayList<Rock> rockList) {
        this.rockList = rockList;
    }

    public void refresh() {
        for(Rock rock: rockList) {
            refresh(rock.getPosition());
        }
    }

    public void refresh(Position position) {

        char bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()-1);
        char leftTile = map.getCharByPos(position.getPosX()-1, position.getPosY());
        char rightTile = map.getCharByPos(position.getPosX()+1, position.getPosY());
        char bottomLeftTile = map.getCharByPos(position.getPosX()-1, position.getPosY()-1);
        char bottomRightTile = map.getCharByPos(position.getPosX()+1, position.getPosY()-1);

        if (bottomTile == '7')//monstre
            explode(true, position);
        else if (bottomTile == '0')//bloc cassable
            explode(false, position);
        else if (bottomTile == '2')//vide
            rock.moveD(position);
        else {
            ref = bottomLeftTile.getRef();
            if (leftTile.getRef() == '2' && (ref == '0' || ref == '2' || ref == '7'))//vide
                rock.moveL(position);
            else {
                ref = bottomRightTile.getRef();
                if (rightTile.getRef() == '2' && (ref == '0' || ref == '2' || ref == '7'))//vide
                    rock.moveR(position);
            }
        }

        position = rock.getPosition();
        bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()-1);

        if(bottomTile.getRef() == '2')
            setTimeout(() -> refresh(rock), 500);
    }

    public void refresh(char tileRef){
        
    }

    private void explode(boolean diamondShower, Position position) {
        
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


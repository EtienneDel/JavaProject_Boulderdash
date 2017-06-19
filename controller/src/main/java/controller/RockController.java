/*
package controller;

import model.Position;
import model.Rock;
import model.Tile;

import java.util.ArrayList;

*/
/**
 * Created by Julien on 16/06/2017.
 *//*

public class RockController {

    private ArrayList<Rock> rockList;

    public RockController(ArrayList<Rock> rockList) {
        this.rockList = rockList;
    }

    public void refresh() {
        for(Rock rock: rockList) {
            refresh(rock);
        }
    }

    public void refresh(Position position) {
        Rock rock = new Rock(0,0);
        refresh(rock.getTileByPos(position.getPosX(), position.getPosY()));
    }

*/
/*
    public void refresh(Rock rock){
        Position position = rock.getPosition();

        Tile bottomTile = rock.getTileByPos(position.getPosX(), position.getPosY()-1);
        Tile leftTile = rock.getTileByPos(position.getPosX()-1, position.getPosY());
        Tile rightTile = rock.getTileByPos(position.getPosX()+1, position.getPosY());
        Tile bottomLeftTile = rock.getTileByPos(position.getPosX()-1, position.getPosY()-1);
        Tile bottomRightTile = rock.getTileByPos(position.getPosX()+1, position.getPosY()-1);

        int ref = bottomTile.getRef();
        if (ref == '7')//monstre
            explode(true, position);
        else if (ref == '0')//bloc cassable
            explode(false, position);
        else if (ref == '2')//vide
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
        bottomTile = rock.getTileByPos(position.getPosX(), position.getPosY()-1);

        if(bottomTile.getRef() == '2')
            setTimeout(() -> refresh(rock), 500);
    }
*//*


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
*/

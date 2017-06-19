package controller;

import model.Diamond;
import model.Position;
import model.Tile;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Julien on 17/06/2017.
 */

public class DiamondController {
    private ArrayList<Diamond> diamondList;

    public DiamondController(ArrayList<Diamond> diamondList) {
        this.diamondList = diamondList;
    }

    public void refresh() {
        for(Diamond diamond: diamondList) {
            refresh(diamond);
        }
    }

    public void refresh(Position position) throws IOException {
        Diamond diamond = new Diamond(0,0);
        refresh(diamond.getCharByPos(position.getPosX(), position.getPosY()));
    }

    public void refresh(Diamond diamond){
        Position position = diamond.getPosition();

        Tile bottomTile = diamond.getCharByPos(position.getPosX(), position.getPosY()-1);
        Tile leftTile = diamond.getCharByPos(position.getPosX()-1, position.getPosY());
        Tile rightTile = diamond.getCharByPos(position.getPosX()+1, position.getPosY());
        Tile bottomLeftTile = diamond.getCharByPos(position.getPosX()-1, position.getPosY()-1);
        Tile bottomRightTile = diamond.getCharByPos(position.getPosX()+1, position.getPosY()-1);

        int ref = bottomTile.getRef();
        if (ref == '7')//monstre
            explode(true, position);
        else if (ref == '0')//bloc cassable
            explode(false, position);
        else if (ref == '2')//vide
            diamond.moveD(position);
        else {
            ref = bottomLeftTile.getRef();
            if (leftTile.getRef() == '2' && (ref == '0' || ref == '2' || ref == '7'))//vide
                diamond.moveL(position);
            else {
                ref = bottomRightTile.getRef();
                if (rightTile.getRef() == '2' && (ref == '0' || ref == '2' || ref == '7'))//vide
                    diamond.moveR(position);
            }
        }

        position = diamond.getPosition();
        bottomTile = diamond.getCharByPos(position.getPosX(), position.getPosY()-1);

        if(bottomTile.getRef() == '2')
            setTimeout(() -> refresh(diamond), 500);
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


package controller;/*package controller;

import model.Map;
import model.Position;
import model.Rock;
import model.dao.MapDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Julien on 16/06/2017.
 */
/*
public class RockController {

    private MapDAO mapDAO = MapDAO.getMapDAO();
    private Map map = Map.getMap();
    private ArrayList<Rock> rockList;

    public RockController() throws IOException {
        this.rockList = map.getListRock();
    }

    public void refresh() {
        for(Rock rock: rockList) {
            refresh(rock.getPosition());
        }
    }

    public void refresh(Position position) {
        Rock rock = map.getRockByPos(position);

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
            if (leftTile == '2' && (bottomLeftTile == '0' || bottomLeftTile == '2' || bottomLeftTile == '7'))//vide
                rock.moveL(position);
            else {
                if (rightTile == '2' && (bottomRightTile == '0' || bottomRightTile == '2' || bottomRightTile == '7'))//vide
                    rock.moveR(position);
            }
        }

        position = rock.getPosition();
        bottomTile = map.getCharByPos(position.getPosX(), position.getPosY()-1);
        //permet de ré update le caillou si y'a du vide dessous
        //todo supprimer ?
        if(bottomTile == '2') {
            Position finalPosition = position;
            setTimeout(() -> refresh(finalPosition), 500);
        }
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
*/

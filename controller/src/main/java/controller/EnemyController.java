package controller;

import model.Enemy;
import model.Map;
import model.Position;
import model.dao.MapDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Julien on 17/06/2017.
 */
public class EnemyController {
    private MapDAO mapDAO = new MapDAO();
    private Map map = Map.getMap(mapDAO);
    private ArrayList<Enemy> enemyList;

    public EnemyController(ArrayList<Enemy> enemyList) throws IOException {
        this.enemyList = enemyList;
    }

    public void refresh() {
        int i = 0;
        for(Enemy enemy: enemyList) {

            if(isInFirstLoop(enemy.lastDirection))
            {
                if(canMoveLeft(enemy.getPosition()))
                    enemy.moveL(enemy.getPosition());
                else if(canMoveUp(enemy.getPosition()))
                    enemy.moveU(enemy.getPosition());
                else
                    i++;
            }

        }

        setTimeout(this::refresh, 500);
    }


    private void explode(boolean diamondShower, Position position) {

    }

    private boolean canMoveUp(Position position) {
        return map.getCharByPos(position.getPosX(), position.getPosY()+1) == '2';
    }

    private boolean canMoveDown(Position position) {
        return map.getCharByPos(position.getPosX(), position.getPosY()-1) == '2';
    }
    private boolean canMoveRight(Position position) {
        return map.getCharByPos(position.getPosX()+1, position.getPosY()) == '2';
    }
    private boolean canMoveLeft(Position position) {
        return map.getCharByPos(position.getPosX()-1, position.getPosY()) == '2';
    }

    private boolean isInFirstLoop(int lastDirection) {
        return lastDirection == 0 || lastDirection == 1;
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

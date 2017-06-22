package controller;

import model.IEnemies;
import model.IMap;
import model.IModel;
import model.IPosition;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Julien on 17/06/2017.
 */

public class EnemyController {
    private IModel model;
    private IMap map;
    private ArrayList<IEnemies> enemyList;

    public EnemyController(IModel model, ArrayList<IEnemies> enemyList) throws IOException {
        this.model = model;
        this.map = model.getTheMap();
    }

    public void refresh() {
        int i = 0;
        for(IEnemies enemy: enemyList) {
            while(i != 0) {
                if (isInFirstLoop(enemy.getLastDirection())) {
                    if (canMoveLeft(enemy.getPosition()))
                        enemy.moveLeft(enemy.getPosition());
                    else if (canMoveUp(enemy.getPosition()))
                        enemy.moveUp(enemy.getPosition());
                    else
                        i++;
                } else {
                    if (canMoveRight(enemy.getPosition()))
                        enemy.moveRight(enemy.getPosition());
                    else if (canMoveDown(enemy.getPosition()))
                        enemy.moveDown(enemy.getPosition());
                    else
                        i++;
                }
            }
        }
    }

    private boolean canMoveUp(IPosition position) {
        return map.getCharByPos(position.getPosX(), position.getPosY()-1) == '2';
    }

    private boolean canMoveDown(IPosition position) {
        return map.getCharByPos(position.getPosX(), position.getPosY()+1) == '2';
    }
    private boolean canMoveRight(IPosition position) {
        return map.getCharByPos(position.getPosX()+1, position.getPosY()) == '2';
    }
    private boolean canMoveLeft(IPosition position) {
        return map.getCharByPos(position.getPosX()-1, position.getPosY()) == '2';
    }

    private boolean isInFirstLoop(int lastDirection) {
        return lastDirection == 0 || lastDirection == 1;
    }
}

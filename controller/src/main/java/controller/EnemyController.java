package controller;

import model.IEnemies;
import model.IMap;
import model.IModel;
import model.IPosition;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The Class EnemyController provides movement for the enemies.
 */
public class EnemyController {
    private IModel model;
    private IMap map;
    private ArrayList<IEnemies> enemyList;

    /**
     * Instantiates a new Enemy controller.
     *
     * @param model     the model
     * @param enemyList the enemy list
     * @throws IOException the io exception
     */
    public EnemyController(IModel model, ArrayList<IEnemies> enemyList) throws IOException {
        this.model = model;
        this.map = model.getTheMap();
        this.enemyList = enemyList;
    }

    /**
     * Clock wise.
     *
     * @param enemy the enemy
     */
    public void clockWise(IEnemies enemy) {
        int i = 0;
        do {
            if (isInFirstLoop(enemy.getLastDirection(), enemy.getAlgo())) {
                if (canMoveRight(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 1)) {
                    enemy.moveRight(enemy.getPosition());
                    i = 0;
                } else if (canMoveDown(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 0)) {
                    enemy.moveDown(enemy.getPosition());
                    i = 0;
                } else if (canMoveLeft(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 1)) {
                    enemy.moveLeft(enemy.getPosition());
                    i = 0;
                } else if (canMoveUp(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 0)) {
                    enemy.moveUp(enemy.getPosition());
                    i = 0;
                } else
                    i++;
            } else {
                if (canMoveLeft(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 1)) {
                    enemy.moveLeft(enemy.getPosition());
                    i = 0;
                } else if (canMoveUp(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 0)) {
                    enemy.moveUp(enemy.getPosition());
                    i = 0;
                } else if (canMoveRight(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 1)) {
                    enemy.moveRight(enemy.getPosition());
                    i = 0;
                } else if (canMoveDown(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 0)) {
                    enemy.moveDown(enemy.getPosition());
                    i = 0;
                } else
                    i++;
            }
        } while (i != 0);
    }

    /**
     * Anti clock wise.
     *
     * @param enemy the enemy
     */
    public void antiClockWise(IEnemies enemy) {
        int i = 0;
        do {
            if (isInFirstLoop(enemy.getLastDirection(), enemy.getAlgo())) {
                if (canMoveRight(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 1)) {
                    enemy.moveRight(enemy.getPosition());
                    i = 0;
                } else if (canMoveUp(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 0)) {
                    enemy.moveUp(enemy.getPosition());
                    i = 0;
                } else if (canMoveLeft(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 1)) {
                    enemy.moveLeft(enemy.getPosition());
                    i = 0;
                } else if (canMoveDown(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 0)) {
                    enemy.moveDown(enemy.getPosition());
                    i = 0;
                } else
                    i++;
            } else {
                if (canMoveLeft(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 1)) {
                    enemy.moveLeft(enemy.getPosition());
                    i = 0;
                } else if (canMoveDown(enemy.getPosition()) && (enemy.getLastDirection() != 2 || i > 0)) {
                    enemy.moveDown(enemy.getPosition());
                    i = 0;
                } else if (canMoveRight(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 1)) {
                    enemy.moveRight(enemy.getPosition());
                    i = 0;
                } else if (canMoveUp(enemy.getPosition()) && (enemy.getLastDirection() != 0 || i > 0)) {
                    enemy.moveUp(enemy.getPosition());
                    i = 0;
                } else
                    i++;
            }
        } while (i != 0);
    }

    /**
     * Vertical.
     *
     * @param enemy the enemy
     */
    public void vertical(IEnemies enemy) {
        if (enemy.getLastDirection() == 1) {
            if (canMoveUp(enemy.getPosition()))
                enemy.moveUp(enemy.getPosition());
            else if (canMoveDown(enemy.getPosition()))
                enemy.moveDown(enemy.getPosition());
        } else {
            if (canMoveDown(enemy.getPosition()))
                enemy.moveDown(enemy.getPosition());
            else if (canMoveUp(enemy.getPosition()))
                enemy.moveUp(enemy.getPosition());
        }
    }

    /**
     * Horizontal.
     *
     * @param enemy the enemy
     */
    public void horizontal(IEnemies enemy) {
        if (enemy.getLastDirection() == 0) {
            if (canMoveLeft(enemy.getPosition()))
                enemy.moveLeft(enemy.getPosition());
            else if (canMoveRight(enemy.getPosition()))
                enemy.moveRight(enemy.getPosition());
        } else {
            if (canMoveRight(enemy.getPosition()))
                enemy.moveRight(enemy.getPosition());
            else if (canMoveLeft(enemy.getPosition()))
                enemy.moveLeft(enemy.getPosition());
        }
    }

    /**
     * Refresh.
     */
    public void refresh() {
        for (IEnemies enemy : enemyList) {
            switch (enemy.getAlgo()) {
                case 0:
                    clockWise(enemy);
                    break;
                case 1:
                    antiClockWise(enemy);
                    break;
                case 2:
                    vertical(enemy);
                    break;
                case 3:
                    horizontal(enemy);
                    break;
            }
            if(map.getCharByPos(enemy.getPosition().getPosX(), enemy.getPosition().getPosY()) != '7')
                enemyList.remove(enemy);
        }

    }

    protected void explode(IPosition position) {
        position.setPosition(position.getPosX(), position.getPosY() + 1);
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                map.setCharByPos(position.getPosX() + i, position.getPosY() + j, '2');
    }

    private boolean canMoveUp(IPosition position) {
        char tile = map.getCharByPos(position.getPosX(), position.getPosY() - 1);
        if(tile == '8')
            explode(model.getPosition(position.getPosX(), position.getPosY() - 1));
        return map.getCharByPos(position.getPosX(), position.getPosY() - 1) == '2';
    }

    private boolean canMoveDown(IPosition position) {
        char tile = map.getCharByPos(position.getPosX(), position.getPosY()+1);
        if(tile == '8')
            explode(model.getPosition(position.getPosX(), position.getPosY() + 1));
        return map.getCharByPos(position.getPosX(), position.getPosY() + 1) == '2';
    }

    private boolean canMoveRight(IPosition position) {
        char tile = map.getCharByPos(position.getPosX()+1, position.getPosY());
        if(tile == '8')
            explode(model.getPosition(position.getPosX()+1, position.getPosY()));
        return map.getCharByPos(position.getPosX()+1, position.getPosY()) == '2';
    }

    private boolean canMoveLeft(IPosition position) {
        char tile = map.getCharByPos(position.getPosX()-1, position.getPosY());
        if(tile == '8')
            explode(model.getPosition(position.getPosX()-1, position.getPosY()));
        return map.getCharByPos(position.getPosX()-1, position.getPosY()) == '2';
    }

    private boolean isInFirstLoop(int lastDirection, int algo) {
        if(algo == 0)
            return lastDirection == 0 || lastDirection == 3;
        if(algo == 1)
            return lastDirection == 0 || lastDirection == 1;
        return false;
    }
}

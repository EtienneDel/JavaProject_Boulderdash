package controller;

import model.Enemy;
import model.Position;
import model.Tile;

import java.util.ArrayList;

/**
 * Created by Julien on 17/06/2017.
 */
public class EnemyController {

    private ArrayList<Enemy> enemyList;

    public EnemyController(ArrayList<Enemy> enemyList) {
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
        Tile topTile = diamond.getCharByPos(position.getPosX(), position.getPosY()+1);

        return topTile.getRef() == '2';
    }

    private boolean canMoveDown(Position position) {
        Tile bottomTile = diamond.getCharByPos(position.getPosX(), position.getPosY()-1);

        return bottomTile.getRef() == '2';
    }

    private boolean canMoveLeft(Position position) {
        Tile leftTile = diamond.getCharByPos(position.getPosX()-1, position.getPosY());

        return leftTile.getRef() == '2';
    }

    private boolean canMoveRight(Position position) {
        Tile rightTile = diamond.getCharByPos(position.getPosX()+1, position.getPosY());

        return rightTile.getRef() == '2';
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

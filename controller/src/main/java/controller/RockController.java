package controller;

import model.Rock;

/**
 * Created by Julien on 16/06/2017.
 */
public class RockController extends Rock{
    public RockController(int x, int y) {
        super(x, y);
    }

    public void refresh() {
        int bottomTile = getTileByPos(position.getPosX(), position.getPosY() - 1);

        while(bottomTile == '0' || bottomTile == '7' || bottomTile == '2') {
            if(bottomTile == '7')
                explode(true, position.getPosX(), position.getPosY() - 1);
            else if(bottomTile == '0')
                explode(false, position.getPosX(), position.getPosY() - 1);
            else
                setPosition(position.getPosX(), position.getPosY() - 1);
        }
    }

    private void explode(boolean diamondShower, int x, int y) {
        
    }
}

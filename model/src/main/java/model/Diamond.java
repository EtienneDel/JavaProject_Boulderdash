package model;
/**
 * <h1>the Diamond class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Diamond extends Tile implements Breakable, Movable {

    /**
     * constructor
     * @param x
     * @param y
     */
    private SpriteSheet spriteSheet;
    private static BufferedImage diamond;

    public Diamond(int x, int y) throws IOException {
        super(x, y);
        spriteSheet = new SpriteSheet();
        diamond = spriteSheet.crop(WIDTH*4,0,WIDTH,HEIGHT);
        setRef(4);
        setWalkable(true);

    }

    public static BufferedImage getDiamond() {
        return diamond;
    }


    /**
     * if the diamond is taken
     */
    @Override
    public void isBreak() {
        setRef(2);
    }

    /**
     * move up
     * @param position
     */
    @Override
    public void moveU(Position position) {
    }

    /**
     * move down
     * @param position
     */
    @Override
    public void moveD(Position position) {
        int y = position.getPosY();
        setPosition(position.getPosX(), y+1);
    }

    /**
     * move left
     * @param position
     */
    @Override
    public void moveL(Position position) {
    }

    /**
     * move right
     * @param position
     */
    @Override
    public void moveR(Position position) {
    }
}

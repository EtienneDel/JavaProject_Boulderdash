package model;
/**
 * <h1>the BWall class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BWall extends Tile implements Breakable {
    /**
     * constructor
     * @param x
     * @param y
     */

    private SpriteSheet spriteSheet;
    private static BufferedImage bWall;

    public BWall(int x, int y) throws IOException {
        super(16,16);

        spriteSheet = new SpriteSheet();
        bWall = spriteSheet.crop(WIDTH*8,0,WIDTH,HEIGHT);
        setRef(3);

    }

    public static BufferedImage getbWall() {
        return bWall;
    }

    /**
     * if the object break
     */
    @Override
    public void isBreak() {

        setRef(2);
        setWalkable(false);

    }
}

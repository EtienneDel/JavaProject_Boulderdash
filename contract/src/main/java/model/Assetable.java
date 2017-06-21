package model;

import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 20/06/2017.
 */
public interface Assetable {

    BufferedImage getDirt();
    BufferedImage getWall();
    BufferedImage getBwall();
    BufferedImage getEmpty();
    BufferedImage getDiamonds();
    BufferedImage getRock();
    BufferedImage getExit();
    BufferedImage getCharacter();
}

package model;

import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 20/06/2017.
 */
public interface Assetable {

    /**
     * Gets dirt.
     *
     * @return the dirt
     */
    BufferedImage getDirt();

    /**
     * Gets wall.
     *
     * @return the wall
     */
    BufferedImage getWall();

    /**
     * Gets bwall.
     *
     * @return the bwall
     */
    BufferedImage getBwall();

    /**
     * Gets empty.
     *
     * @return the empty
     */
    BufferedImage getEmpty();

    /**
     * Gets diamonds.
     *
     * @return the diamonds
     */
    BufferedImage getDiamonds();

    /**
     * Gets rock.
     *
     * @return the rock
     */
    BufferedImage getRock();

    /**
     * Gets exit.
     *
     * @return the exit
     */
    BufferedImage getExit();

    /**
     * Gets character.
     *
     * @return the character
     */
    BufferedImage getCharacter();

    /**
     * Gets enemy.
     *
     * @return the enemy
     */
    BufferedImage getEnemy();
}

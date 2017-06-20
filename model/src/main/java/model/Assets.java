package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <h1>The Class Assets.</h1>
 *
 * @author Etienne Delnott / Julien Zolli
 * @version 1.0
 */
public class Assets {
    /**
     * Attributes
     */
    private SpriteSheet sprite;
    public BufferedImage wall, dirt, bwall, empty, diamond, rock, exit;

    /**
     * constructor without parameter
     * @throws IOException
     */
    public Assets() throws IOException {
        this.sprite = new SpriteSheet();//instantiate a new spriteSheet
        Tile tile = new Tile(); //instantiate a new tile

        wall = tile.getImageFromTileset(sprite.getImg(),0,0);// cut in the tileset all the tile needed
        dirt = tile.getImageFromTileset(sprite.getImg(),1,0);
        bwall = tile.getImageFromTileset(sprite.getImg(),8,0);
        empty = tile.getImageFromTileset(sprite.getImg(),2,0);
        diamond = tile.getImageFromTileset(sprite.getImg(),4,0);
        rock = tile.getImageFromTileset(sprite.getImg(),3,0);
        exit = tile.getImageFromTileset(sprite.getImg(),6,0);

    }
}

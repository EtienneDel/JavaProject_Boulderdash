package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Julien on 19/06/2017.
 */
public class Assets {

    private SpriteSheet sprite;
    public BufferedImage wall, dirt, bwall, empty, diamond, rock, exit;


    public Assets() throws IOException {
        this.sprite = new SpriteSheet();
        Tile tile = new Tile();

        wall = tile.getImageFromTileset(sprite.getImg(),0,0);
        dirt = tile.getImageFromTileset(sprite.getImg(),1,0);
        bwall = tile.getImageFromTileset(sprite.getImg(),8,0);
        empty = tile.getImageFromTileset(sprite.getImg(),2,0);
        diamond = tile.getImageFromTileset(sprite.getImg(),4,0);
        rock = tile.getImageFromTileset(sprite.getImg(),3,0);
        exit = tile.getImageFromTileset(sprite.getImg(),6,0);

    }
}

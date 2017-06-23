package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <h1>The Class Assets.</h1>
 *
 * @author Etienne Delnott / Julien Zolli
 * @version 1.0
 */
public class Assets implements Assetable {
    /**
     * The Wall.
     */
    public BufferedImage wall, /**
     * The Dirt.
     */
    dirt, /**
     * The Bwall.
     */
    bwall, /**
     * The Empty.
     */
    empty, /**
     * The Diamond.
     */
    diamond, /**
     * The Rock.
     */
    rock, /**
     * The Exit.
     */
    exit, /**
     * The Character.
     */
    character, /**
     * The Enemy.
     */
    enemy;
    /**
     * Attributes
     */
    private SpriteSheet sprite;

    /**
     * constructor without parameter
     *
     * @throws IOException the io exception
     */
    public Assets() throws IOException {
        this.sprite = new SpriteSheet();//instantiate a new spriteSheet
        Tile tile = new Tile(); //instantiate a new tile

        wall = tile.getImageFromTileset(sprite.getImg(), 0, 0);// cut in the tileset all the tile needed
        dirt = tile.getImageFromTileset(sprite.getImg(), 1, 0);
        bwall = tile.getImageFromTileset(sprite.getImg(), 8, 0);
        empty = tile.getImageFromTileset(sprite.getImg(), 2, 0);
        diamond = tile.getImageFromTileset(sprite.getImg(), 4, 0);
        rock = tile.getImageFromTileset(sprite.getImg(), 3, 0);
        exit = tile.getImageFromTileset(sprite.getImg(), 6, 0);
        character = tile.getImageFromTileset(sprite.getImg(), 12, 0);
        enemy = tile.getImageFromTileset(sprite.getImg(), 9, 0);

    }

    @Override
    public BufferedImage getDirt() {
        return dirt;
    }

    @Override
    public BufferedImage getWall() {
        return wall;
    }

    @Override
    public BufferedImage getBwall() {
        return bwall;
    }

    @Override
    public BufferedImage getEmpty() {
        return empty;
    }

    @Override
    public BufferedImage getDiamonds() {
        return diamond;
    }

    @Override
    public BufferedImage getRock() {
        return rock;
    }

    @Override
    public BufferedImage getExit() {
        return exit;
    }

    @Override
    public BufferedImage getCharacter() {
        return character;
    }

    @Override
    public BufferedImage getEnemy() {
        return enemy;
    }

}

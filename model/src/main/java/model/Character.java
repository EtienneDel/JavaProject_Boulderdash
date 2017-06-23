package model;

import java.io.IOException;

/**
 * <h1>the Character class</h1>
 *
 * @author Etienne Delnott / Paul Brouet
 * @version 1.0
 */
public class Character extends Entitie implements Tilable, ICharacter {
    /**
     * attribute
     */
    public final static int REF = 8;
    private Map map = Map.getMap();
    private static Character instance;
    private IPosition position;
    /**
     * constructor with parameter position of the tile
     * @param x
     * @param y
     */
    private Character(int x, int y) throws IOException {
        super(x, y);
        setWalkable(false);
    }


    /**
     * constructor without parameter
     */
    private Character() throws IOException {
        super();
        setWalkable(false);
    }

    /**
     * Sets the character.
     *
     * @param x the x
     * @param y the y
     * @return the the character
     * @throws IOException the io exception
     */
    public static Character setTheCharacter(int x, int y) throws IOException {
        if(instance==null){
            return new Character(x,y);
        }
        return instance;
    }

    /**
     * Gets the character.
     *
     * @return the the character
     * @throws IOException the io exception
     */
    public static Character getTheCharacter() throws IOException {
        if(instance==null){
            return null;
        }
        return instance;
    }

    @Override
    public void moveD(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y,'2');
        map.setCharByPos(x, y+1,'8');
        position.setPosition(position.getPosX(),position.getPosY()-1);
        setPosition(position);
    }

    @Override
    public void moveL(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y,'2');
        map.setCharByPos(x, y+1,'8');
        position.setPosition(position.getPosX()-1,position.getPosY());
        setPosition(position);
    }

    @Override
    public void moveR(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y,'2');
        map.setCharByPos(x, y+1,'8');
        position.setPosition(position.getPosX()+1,position.getPosY());
        setPosition(position);
    }

    @Override
    public void moveU(IPosition position) {
        int x = position.getPosX();
        int y = position.getPosY();
        map.setCharByPos(x, y,'2');
        map.setCharByPos(x, y+1,'8');
        position.setPosition(position.getPosX(),position.getPosY()+1);
        setPosition(position);
    }

    @Override
    public Tilable getCharacter() throws IOException {
        return new Character();
    }

    @Override
    public IPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(IPosition position) {
        this.position = position;
    }

    @Override
    public Boolean getwlakable() {
        return getWalkable();
    }
}

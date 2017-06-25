package controller;

import model.IMap;
import model.IModel;
import model.IPosition;
import model.Movable;
import view.IView;

import java.io.IOException;

/**
 * The Class Character controller provides movements for the character.
 */
public class CharacterController{
    /**
     * The Map.
     */
    protected IMap map;
    /**
     * The Model.
     */
    protected IModel model;
    /**
     * The Build.
     */
    protected IView view;
    protected Build build;
    private IPosition position;
    private RockController rockController;
    private DiamondController diamondController;
    private int colli = 0, nbDiamond, score;
    private Boolean diamond = false;

    /**
     * Instantiates a new Character controller.
     *
     * @param model the model
     * @param build the build
     * @throws IOException the io exception
     */
    public CharacterController(IModel model, Build build, IView view) throws IOException {
        this.map = model.getTheMap();
        this.model = model;
        this.build = build;
        rockController = new RockController(model);
        diamondController = new DiamondController(model);
        nbDiamond = model.getDiamonds();
        score = view.getScore();
    }

    /**
     * Refresh.
     *
     * @param position the position
     * @throws IOException the io exception
     */
    public void refresh(IPosition position) throws IOException {
        this.position = position;

        if (!(position.getPosX() > 0 && position.getPosY() > 0 && (map.getCharByPos(position.getPosX(), position.getPosY()) == '4') || map.getCharByPos(position.getPosX(), position.getPosY()) == '8'))
            return;
        switch (map.getCharByPos(position.getPosX(), position.getPosY())) {
            case '4':
                diamondController.refresh(position);
                break;
            case '5':
                rockController.refresh(position);
                break;
        }
    }

    /**
     * Move up.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    protected void moveUp(Movable movable, IPosition position) throws IOException {
        switch (map.getCharByPos(position.getPosX(), position.getPosY() - 1)) {
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '4':
                diamond = true;
                movable.moveU(position);
                break;
            case '5':
                colli = 1;
                break;
            case '6':
                if(score >= nbDiamond){
                    colli = 4;
                    movable.moveU(position);
                }
                else if(score < nbDiamond){
                    colli = 1;
                }
            default:
                movable.moveU(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    /**
     * Move down.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    protected void moveDown(Movable movable, IPosition position) throws IOException {
        switch (map.getCharByPos(position.getPosX(), position.getPosY() + 1)) {
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '4':
                diamond = true;
                movable.moveD(position);
                break;
            case '5':
                colli = 1;
                break;
            case '6':
                if(score >= nbDiamond){
                    colli = 4;
                    movable.moveD(position);
                }
                else if(score < nbDiamond){
                    colli = 1;
                }
            default:
                movable.moveD(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    /**
     * Move left.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    protected void moveLeft(Movable movable, IPosition position) throws IOException {
        switch (map.getCharByPos(position.getPosX() - 1, position.getPosY())) {
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '4':
                diamond = true;
                movable.moveL(position);
                break;
            case '5':
                if (map.getCharByPos(position.getPosX() - 2, position.getPosY()) == '2') {
                    colli = 2;
                    movable.moveL(position);
                } else {
                    colli = 1;
                }
                break;
            case '6':
                if(score >= nbDiamond){
                    colli = 4;
                    movable.moveL(position);
                }
                else if(score < nbDiamond){
                    colli = 1;
                }
            default:
                movable.moveL(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    /**
     * Move right.
     *
     * @param movable  the movable
     * @param position the position
     * @throws IOException the io exception
     */
    protected void moveRight(Movable movable, IPosition position) throws IOException {
        switch (map.getCharByPos(position.getPosX() + 1, position.getPosY())) {
            case '1':
                colli = 1;
                break;
            case '3':
                colli = 1;
                break;
            case '4':
                diamond = true;
                movable.moveR(position);
                break;
            case '5':
                colli = 1;
                break;
            case '6':
                if(score >= nbDiamond){
                    colli = 4;
                    movable.moveR(position);
                }
                else if(score < nbDiamond){
                    colli = 1;
                }
            default:
                movable.moveR(position);
        }
        build.calculateMap();
        refreshAround(position);
    }

    /**
     * Refresh around.
     *
     * @param position the position
     * @throws IOException the io exception
     */
    protected void refreshAround(IPosition position) throws IOException {

        refresh(model.getPosition(position.getPosX(), position.getPosY() - 1));
        refresh(model.getPosition(position.getPosX() - 1, position.getPosY()));
        refresh(model.getPosition(position.getPosX() + 1, position.getPosY()));
        refresh(model.getPosition(position.getPosX(), position.getPosY() + 1));
    }

    /**
     * Gets colli.
     *
     * @return the colli
     */
    public int getColli() {
        return colli;
    }

    public Boolean getDiamond() {
        return diamond;
    }
}

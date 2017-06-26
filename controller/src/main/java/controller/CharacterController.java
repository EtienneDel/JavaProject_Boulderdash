package controller;

import model.*;
import view.IView;

import java.io.IOException;

/**
 * The Class Character controller provides movements for the character.
 */
public class CharacterController implements OrderPerformerable {
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
    /**
     * The Build.
     */
    protected Build build;
    private IPosition position;
    private ICharacter character;
    private Movable movable;
    private Movable rock;
    private RockController rockController;
    private DiamondController diamondController;
    private int colli = 0, nbDiamond, score;
    private Boolean diamond = false;

    /**
     * Instantiates a new Character controller.
     *
     * @param model the model
     * @param build the build
     * @param view  the view
     * @throws IOException the io exception
     */
    public CharacterController(IModel model, Build build, IView view) throws IOException {
        this.map = model.getTheMap();
        this.model = model;
        this.build = build;
        rockController = new RockController(model);
        diamondController = new DiamondController(model);
        character = model.setTheCharacterA(1, 1);
        this.movable = (Movable) character;
        this.rock = (Movable) model.getRock();
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
        if (!(position.getPosX() > 0 && position.getPosY() > 0 && (map.getCharByPos(position.getPosX(), position.getPosY()) == '4') || map.getCharByPos(position.getPosX(), position.getPosY()) == '5'))
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
                break;
            case '7':
                map.setCharByPos(position.getPosX(), position.getPosY(), '2');
                break;
            default:
                movable.moveU(position);
        }
        refreshAround(position);
    }

    /**
     * Move down.
     *
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
                break;
            case '7':
                map.setCharByPos(position.getPosX(), position.getPosY(), '2');
                break;
            default:
                movable.moveD(position);
        }
        refreshAround(position);
    }

    /**
     * Move left.
     *
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
                    rockController.moveLeft(rock, model.getPosition(position.getPosX() - 1, position.getPosY()));
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
                break;
            case '7':
                map.setCharByPos(position.getPosX(), position.getPosY(), '2');
                break;
            default:
                movable.moveL(position);
        }
        refreshAround(position);
    }

    /**
     * Move right.
     *
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
                if (map.getCharByPos(position.getPosX() + 2, position.getPosY()) == '2') {
                    colli = 2;
                    rockController.moveRight(rock, model.getPosition(position.getPosX() + 1, position.getPosY()));
                    movable.moveR(position);
                } else {
                    colli = 1;
                }
                break;
            case '6':
                if(score >= nbDiamond){
                    colli = 4;
                    rockController.moveRight(rock, model.getPosition(position.getPosX() + 1, position.getPosY()));
                    movable.moveR(position);
                }
                else if(score < nbDiamond){
                    colli = 1;
                }
                break;
            case '7':
                map.setCharByPos(position.getPosX(), position.getPosY(), '2');
                break;
            default:
                movable.moveR(position);
        }
        refreshAround(position);
    }

    /**
     * Refresh around.
     *
     * @param position the position
     * @throws IOException the io exception
     */
    protected void refreshAround(IPosition position) throws IOException {
        Thread thread;
        thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                refresh(model.getPosition(position.getPosX(), position.getPosY() - 1));
                refresh(model.getPosition(position.getPosX() - 1, position.getPosY()));
                refresh(model.getPosition(position.getPosX() + 1, position.getPosY()));
                refresh(model.getPosition(position.getPosX(), position.getPosY() + 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        thread.start();
    }

    @Override
    public void orderPerformer(UserOrderable userOrder) throws IOException {
        Movable movable = (Movable) model.getTheCharacterA();

        switch (userOrder.getOrder()) {
            case UP:
                moveUp(movable, position);
                break;
            case DOWN:
                moveDown(movable, position);
                break;
            case LEFT:
                moveLeft(movable, position);
                break;
            case RIGHT:
                moveRight(movable, position);
                break;
        }
    }

    /**
     * Gets colli.
     *
     * @return the colli
     */
    public int getColli() {
        return colli;
    }

    /**
     * Gets diamond.
     *
     * @return the diamond
     */
    public Boolean getDiamond() {
        return diamond;
    }
}

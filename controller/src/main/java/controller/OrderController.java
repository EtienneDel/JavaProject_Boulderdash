package controller;

import model.IModel;
import model.IPosition;
import model.Movable;
import view.IView;

import java.io.IOException;

/**
 * The Class OrderController provides movements for the view and the character.
 */
public class OrderController extends java.util.Observable {
    private Build build;
    private CharacterController character;
    private IModel model;
    private IView view;
    private IPosition position;
    private int i = 1, j = 1;
    private int scoreContr;
    private int collision;
    private RockController rockController;
    private ControllerFacade controllerFacade;

    /**
     * Instantiates a new Order controller.
     *
     * @param build the build
     */
    public OrderController(Build build) {
        this.build = build;
    }


    /**
     * Perform order.
     *
     * @param userOrder the user order
     * @param model     the model
     * @param view      the view
     * @throws IOException the io exception
     */
    public void performOrder(UserOrderable userOrder, IModel model, IView view) throws IOException {
        if(ControllerFacade.isEnded)
            return;
        int x = build.getPosX();
        int y = build.getPosY();
        this.view = view;
        this.model = model;
        character = new CharacterController(model, build, view);
        Movable movable = (Movable) model.getDiamond();
        position = model.getPosition(i, j);
        rockController = new RockController(model);
        controllerFacade = new ControllerFacade(model);


        switch (userOrder.getOrder()) {
            case UP:
                character.moveUp(movable, position);
                collision = character.getColli();
                if(character.getDiamond() == true){
                    this.scoreContr ++;
                    view.setScore(scoreContr);
                }
                if(collision == 4){
                    i--;
                    x += 16;
                    controllerFacade.endGame(view, model);
                }
                if (collision != 1) {
                    j--;
                    y += 16;
                }


                break;
            case DOWN:

                character.moveDown(movable, position);
                collision = character.getColli();
                if(character.getDiamond() == true) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                if(collision == 4){
                    i--;
                    x += 16;
                    controllerFacade.endGame(view, model);
                }
                if (collision != 1) {
                    j++;
                    y -= 16;
                }
                break;
            case LEFT:
                character.moveLeft(movable, position);
                collision = character.getColli();
                /*if(collision ==2){
                    rockController.moveLeft(movable, position);
                    i--;
                    x += 16;
                }*/
                if(character.getDiamond() == true) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                if(collision == 4){
                    i--;
                    x += 16;
                    controllerFacade.endGame(view, model);
                }
                if (collision != 1 || collision != 2) {
                    i--;
                    x += 16;
                }
                break;
            case RIGHT:

                character.moveRight(movable, position);
                collision = character.getColli();
                if(character.getDiamond() == true) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                if(collision == 4){
                    i--;
                    x += 16;
                    controllerFacade.endGame(view, model);
                }
                if (collision != 1) {
                    i++;
                    x -= 16;
                }
                break;
        }
        character.refreshAround(position);
        build.setPos(x, y);
        setChanged();
        notifyObservers();
    }
}

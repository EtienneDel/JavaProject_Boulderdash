package controller;

import model.IMap;
import model.IModel;
import model.IPosition;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class MainController centralize the movements of the diamonds and rocks.
 */
public class MainController implements Observer {
    private CharacterController characterController;
    private RockController rockController;
    private DiamondController diamondController;
    private IModel model;
    private Build build;
    private EnemyController enemyController;

    /**
     * Instantiates a new Main controller.
     *
     * @param model the model
     * @param build the build
     */
    public MainController(IModel model, Build build) {
        this.model = model;
        this.build = build;
    }

    /**
     * Test.
     *
     * @throws IOException the io exception
     */
    public void test() throws IOException {
        IPosition position = model.getPosition(3, 1);
        IPosition positionChar = model.getPosition(1, 1);
        IMap map = model.getTheMap();
        rockController = new RockController(model);
        diamondController = new DiamondController(model);
        enemyController = new EnemyController(model, model.createEnemyList());

        position.setPosition(7, 4);
        diamondController.refresh(position);

        //characterController.refresh(positionChar);
        position.setPosition(5, 4);
        rockController.refresh(position);
        position.setPosition(3, 7);
        rockController.refresh(position);
        if (model.createEnemyList() != null)
            while (true) {
                enemyController.refresh();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    @Override
    public void update(Observable o, Object arg) {
        build.calculateMap();
    }
}

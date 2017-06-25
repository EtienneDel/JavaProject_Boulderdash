package controller;

import model.IMap;
import model.IModel;
import model.IPosition;
import view.IView;

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
    private IView view;
    private IMap map;
    private ControllerFacade controler;
    private EnemyController enemyController;

    /**
     * Instantiates a new Main controller.
     *
     * @param model the model
     * @param build the build
     */
    public MainController(IModel model, Build build, ControllerFacade controler, IView view) throws IOException {
        this.model = model;
        this.build = build;
        this.controler = controler;
        this.view = view;
        map = model.getTheMap();
    }

    /**
     * Test.
     *
     * @throws IOException the io exception
     */
    public void test() throws IOException {
        Thread thread;

        rockController = new RockController(model);
        diamondController = new DiamondController(model);
        enemyController = new EnemyController(model, model.createEnemyList());
        if (model.createEnemyList() != null) {
            thread = new Thread() {
                public void run() {
                    while (true) {
                        enemyController.refresh();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(ControllerFacade.isEnded)
            return;
        if(!map.isHeroPresent()) {
            controler.endGame(view, model);
            return;
        }
        build.calculateMap();
    }
}

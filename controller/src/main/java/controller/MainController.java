package controller;

import model.*;
import view.IView;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Julien on 21/06/2017.
 */
public class MainController implements Observer{
    private CharacterController characterController;
    private RockController rockController;
    private DiamondController diamondController;
    private IModel model;
    private Build build;

    public MainController(IModel model, Build build) {
        this.model = model;
        this.build = build;
    }

    public void test() throws IOException {
        IPosition position = model.getPosition(3,1);
        IPosition positionChar = model.getPosition(1,1);
        IMap map = model.getTheMap();
        rockController = new RockController(model);
        diamondController = new DiamondController(model);

        position.setPosition(7,4);
        diamondController.refresh(position);

        //characterController.refresh(positionChar);
        position.setPosition(5,4);
        rockController.refresh(position);
        position.setPosition(3,7);
        rockController.refresh(position);
    }

    @Override
    public void update(Observable o, Object arg) {
        build.calculateMap();
        System.out.println("update");
    }
}

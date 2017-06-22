package controller;

import model.*;
import view.IView;

import java.io.IOException;

/**
 * Created by Julien on 21/06/2017.
 */
public class MainController {
    private CharacterController characterController;
    private RockController rockController;
    private DiamondController diamondController;
    private IModel model;

    public MainController(IModel model) {
        this.model = model;
    }

    public void test() throws IOException {
        IPosition position = model.getPosition(3,1);
        IPosition positionChar = model.getPosition(1,1);
        IMap map = model.getTheMap();
        characterController = new CharacterController(model);
        rockController = new RockController(model);
        diamondController = new DiamondController(model);
        model.setTheCharacterA(1,1);

        position.setPosition(7,4);


        characterController.refresh(positionChar);
        diamondController.refresh(position);
        //position.setPosition(7,3);
        //diamondController.refresh(position);
    }

}

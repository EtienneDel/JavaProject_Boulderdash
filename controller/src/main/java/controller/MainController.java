package controller;

import model.*;
import view.IView;

import java.io.IOException;

/**
 * Created by Julien on 21/06/2017.
 */
public class MainController {
    private RockController rockController;
    private DiamondController diamondController;
    private IModel model;

    public MainController(IModel model) {
        this.model = model;
    }

    public void test() throws IOException {
        IPosition position = model.getPosition(3,1);
        IMap map = model.getTheMap();
        rockController = new RockController(model);
        diamondController = new DiamondController(model);

        position.setPosition(7,4);
        diamondController.refresh(position);
        //position.setPosition(7,3);
        //diamondController.refresh(position);
    }

}

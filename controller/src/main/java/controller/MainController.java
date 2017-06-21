package controller;

import model.*;
import view.IView;

import java.io.IOException;

/**
 * Created by Julien on 21/06/2017.
 */
public class MainController implements IPosition, IRock, IMap, IController{
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

        position.setPosition(3,1);
        rockController.refresh(position);
        position.setPosition(4,1);
        diamondController.refresh(position);
        position.setPosition(5,1);
        rockController.refresh(position);
        System.out.println(map.getCharByPos(3,1));

        System.out.println(map.getCharByPos(3,1));
    }

    @Override
    public IPosition getPosition(int x, int y) {
        return null;
    }

    @Override
    public void setPosition(int x, int y) {

    }

    @Override
    public int getRef() {
        return 0;
    }

    @Override
    public IPosition getPosition() {
        return null;
    }

    @Override
    public void setPosition(IPosition position) {

    }

    @Override
    public int getPosX() {
        return 0;
    }

    @Override
    public int getPosY() {
        return 0;
    }

    @Override
    public void moveD(IPosition position) {

    }

    @Override
    public void moveL(IPosition position) {

    }

    @Override
    public void moveR(IPosition position) {

    }

    @Override
    public void moveU(IPosition position) {

    }

    @Override
    public Tilable getRock() {
        return null;
    }

    @Override
    public IMap getTheMap() {
        return null;
    }

    @Override
    public char getCharByPos(int x, int y) {
        return 'a';
    }

    @Override
    public void setCharByPos(int x, int y, char chare) {

    }

    @Override
    public Tilable getTileByPos(IPosition position) {
        return null;
    }
}

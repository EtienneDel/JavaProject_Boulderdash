package controller;

import model.IModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.IView;

public class ControllerFacadeTest {
    ControllerFacade test;
    IModel model;

    @Before
    public void setUp() throws Exception {

        test = new ControllerFacade(model);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void start() throws Exception {
    }

    @Test
    public void getView() throws Exception {

    }

    @Test
    public void getModel() throws Exception {
    }

}
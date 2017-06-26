package main;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

import java.io.IOException;
import java.sql.SQLException;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean -Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     * @throws SQLException         the sql exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
        ModelFacade model;
        if(args.length > 0)
            model = new ModelFacade(args[0]);
        else
            model = new ModelFacade("map1");
        ControllerFacade controller = new ControllerFacade(model);
        ViewFacade view = new ViewFacade(controller, model);
        controller.setView(view);
        controller.start();
    }
}

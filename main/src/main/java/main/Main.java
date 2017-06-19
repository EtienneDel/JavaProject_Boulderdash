package main;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import controller.ControllerFacade;
import controller.IController;
import model.ModelFacade;
import model.SpriteSheet;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     */
    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
        ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade("map1"));


        try {
            controller.start();

        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
}

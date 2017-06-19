package view;

import controller.IController;
import model.IModel;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

    /**
     * Instantiates a new view facade.
     */

   private GameFrame frame;
   private GraphicBuilder graph;
   private EventPerformer performer;

    public ViewFacade() {
        super();
        frame = new GameFrame();
        graph = new GraphicBuilder();
        performer = new EventPerformer();

    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void drawImage(BufferedImage image, int x, int y) {
        frame.getGamePanel().setImage(image, x, y);
    }
}

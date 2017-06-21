package view;

import controller.*;
import model.IModel;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

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

    public ViewFacade(OrderPerformerable orderPerformer) throws SQLException {
        super();
        frame = new GameFrame(new EventPerformer(orderPerformer));
        graph = new GraphicBuilder();
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

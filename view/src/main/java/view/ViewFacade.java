package view;

import controller.OrderPerformerable;
import model.IModel;

import javax.swing.*;
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

    public ViewFacade(OrderPerformerable orderPerformer, IModel model) throws SQLException {
        super();
        frame = new GameFrame(new EventPerformer(orderPerformer), model);
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
        frame.getGamePanel().propertiespoints();
        int a = 1;
		if (a==2)
            frame.getGamePanel().removepoints();
    }
}

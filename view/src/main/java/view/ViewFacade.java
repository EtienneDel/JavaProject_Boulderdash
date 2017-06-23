package view;

import controller.OrderPerformerable;
import model.IModel;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean -Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

    /**
     * The A.
     */
    int a = 0;
    /**
     * Instantiates a new view facade.
     */
    private GameFrame frame;

    /**
     * Instantiates a new View facade.
     *
     * @param orderPerformer the order performer
     * @param model          the model
     * @throws SQLException the sql exception
     */
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
        frame.getGamePanel().removepoints();
        frame.getGamePanel().propertiespoints();
    }

    @Override
    public void initScore() {
        frame.getGamePanel().propertiespoints();
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void setScore(int score) {

    }
}

package view;

import controller.UserOrderable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

    void drawImage(BufferedImage image, int x, int y);
}

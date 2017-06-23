package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * The Interface EventPerformable using a keyCode.
 */
public interface EventPerformerable {

    void eventPerform(final KeyEvent keyCode) throws IOException;
}

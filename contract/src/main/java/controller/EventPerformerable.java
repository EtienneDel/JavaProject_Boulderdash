package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by Etienne on 21/06/2017.
 */
public interface EventPerformerable {

    public void eventPerform(final KeyEvent keyCode) throws IOException;
}

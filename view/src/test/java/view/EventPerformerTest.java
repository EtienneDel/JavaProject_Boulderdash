package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 23/06/2017.
 */
public class EventPerformerTest {
    /**
     * The Test.
     */
    EventPerformer test;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        test = new EventPerformer();
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Key typed.
     *
     * @throws Exception the exception
     */
    @Test
    public void keyTyped() throws Exception {
        final int expected = KeyEvent.VK_UP;
        test.keyTyped(KeyEvent.VK_UP);
    }


}
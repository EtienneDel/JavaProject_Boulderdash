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
    EventPerformer test;
    @Before
    public void setUp() throws Exception {
        test = new EventPerformer();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void keyTyped() throws Exception {
        final int expected = KeyEvent.VK_UP;
        test.keyTyped(KeyEvent.VK_UP);
    }


}
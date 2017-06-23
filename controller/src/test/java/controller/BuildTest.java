package controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing methods of positions
 */
public class BuildTest {

    private Build build;
    @Before
    public void setUp() throws Exception {
        build = new Build();
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void setPos() throws Exception {

        final int expected = 2;
        build.setPos(2,2);
        assertEquals(expected, build.getPosX());

    }

    @Test
    public void getPosX() throws Exception {

        final int expected = 2;
        build.setPos(2,2);
        assertEquals(expected, build.getPosX());
    }

    @Test
    public void getPosY() throws Exception {

        final int expected = 2;
        build.setPos(2,2);
        assertEquals(expected, build.getPosY());
    }

}
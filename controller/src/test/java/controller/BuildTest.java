package controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing methods of positions
 */
public class BuildTest {

    private Build build;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        build = new Build();
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
     * Sets pos.
     *
     * @throws Exception the exception
     */
    @Test
    public void setPos() throws Exception {

        final int expected = 2;
        build.setPos(2, 2);
        assertEquals(expected, build.getPosX());

    }

    /**
     * Gets pos x.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPosX() throws Exception {

        final int expected = 2;
        build.setPos(2, 2);
        assertEquals(expected, build.getPosX());
    }

    /**
     * Gets pos y.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPosY() throws Exception {

        final int expected = 2;
        build.setPos(2, 2);
        assertEquals(expected, build.getPosY());
    }

}
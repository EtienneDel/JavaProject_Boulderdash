package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ASUS on 23/06/2017.
 */
public class GamePanelTest {
    /**
     * The Test.
     */
    GamePanel test;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        test = new GamePanel();
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
     * Sets image.
     *
     * @throws Exception the exception
     */
    @Test
    public void setImage() throws Exception {

        final int expected = 2;
        final int expected2 = 1;
        test.setImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB), 2, 1);
        assertEquals(expected, test.getXpos());
        assertEquals(expected2, test.getYpos());

    }


    /**
     * Propertiespoints.
     *
     * @throws Exception the exception
     */
    @Test
    public void propertiespoints() throws Exception {


        test.propertiespoints();

        assertNotNull(test.getPoints());

    }


    /**
     * Gets score.
     *
     * @throws Exception the exception
     */
    @Test
    public void getScore() throws Exception {
        final int expected = 0;
        assertEquals(expected, test.getScore());
    }

    /**
     * Sets score.
     *
     * @throws Exception the exception
     */
    @Test
    public void setScore() throws Exception {
        final int expected = 5;
        test.setScore(5);
        assertEquals(expected, test.getScore());
    }

}
package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 23/06/2017.
 */
public class PositionTest {

    Position test;
    @Before
    public void setUp() throws Exception {
        test = new Position(1,1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPosX() throws Exception {
        final int expected = 1;
        assertEquals(expected,test.getPosX());
    }

    @Test
    public void setPosX() throws Exception {
        final int expected = 5;
        test.setPosX(5);
        assertEquals(expected,test.getPosX());
    }

    @Test
    public void getPosY() throws Exception {
        final int expected = 1;
        assertEquals(expected,test.getPosY());
    }

    @Test
    public void setPosY() throws Exception {
        final int expected = 5;
        test.setPosY(5);
        assertEquals(expected,test.getPosY());
    }

    @Test
    public void setPosition() throws Exception {
        final int expected = 5,expected2 = 6;
        test.setPosition(5,6);
        assertEquals(expected,test.getPosX());
        assertEquals(expected2,test.getPosY());
    }

    @Test
    public void getPosition() throws Exception {
        assertNotNull(test.getPosition(5,6));

    }

}
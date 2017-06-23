package model;

import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 23/06/2017.
 */
public class RockTest {
    private Rock test;
    private Position position;
    @Before
    public void setUp() throws Exception {
        MapDAO.setMapDAO("map1");
        test = new Rock(1,1);
        position = new Position(1,1);
        test.setPosition(position);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveU() throws Exception {
        final int expected = 1;
        test.moveU(test.getPosition());

        assertEquals(expected,test.getPosition().getPosY());
    }

    @Test
    public void moveD() throws Exception {
        final int expected = 1;
        test.moveD(test.getPosition());

        assertEquals(expected,test.getPosition().getPosY());

    }

    @Test
    public void moveL() throws Exception {
        final int expected = 1;
        test.moveL(test.getPosition());

        assertEquals(expected,test.getPosition().getPosY());
    }

    @Test
    public void moveR() throws Exception {
        final int expected = 1;
        test.moveR(test.getPosition());

        assertEquals(expected,test.getPosition().getPosY());
    }



}
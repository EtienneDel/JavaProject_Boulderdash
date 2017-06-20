package controller;

import model.Diamond;
import model.Position;
import model.Tile;
import model.Wall;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ASUS on 20/06/2017.
 */
public class DiamondControllerTest {
    Tile tile;
    Tile tile2;
    Position position;
    DiamondController test;
    @Before
    public void setUp() throws Exception {
        tile = new Diamond(1,1);
        position = new Position(1,1);
        test = new DiamondController();
        tile2 = new Wall(1,3);

    }

    @After
    public void tearDown() throws Exception {

    }

}

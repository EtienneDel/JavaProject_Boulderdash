package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by ASUS on 16/06/2017.
 */
public class TileTest {

    private Tile tile;
    int test = 1;

    @Before
    public void setUp() throws Exception {
        tile = new Tile(1,1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void setRef(){
        final int expected  = 1;
        tile.setRef(1);
        assertEquals(expected, tile.getRef());

    }
    @Test
    public void setWalkable(){
        final boolean expected = true;
        tile.setWalkable(true);
        assertEquals(expected, tile.getWalkable());
    }

}

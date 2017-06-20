package model;

import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


/**
 * Created by ASUS on 16/06/2017.
 */
public class TileTest {

    private Tile tile;
    private MapDAO mapDAO;



    int test = 1;

    @Before
    public void setUp() throws Exception {
        mapDAO = MapDAO.getMapDAO();
        tile = new Tile(1,1, mapDAO);







    }

    @After
    public void tearDown() throws Exception {

    }




    @Test
    public void setWalkable(){
        final boolean expected = true;
        tile.setWalkable(true);
        assertEquals(expected, tile.getWalkable());
    }


}

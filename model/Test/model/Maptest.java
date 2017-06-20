package model;


import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ASUS on 20/06/2017.
 */
public class Maptest {

    private Map test;
    private MapDAO test2;
    @Before
    public void setUp() throws Exception {

        this.test2 = MapDAO.getMapDAO();
        this.test = Map.getMap();

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void createTileTable(){
        final int expected = 0;

        createTileTable();



    }
    @Test
    public void getCharByPos() throws IOException, SQLException {
        final int expected = '0';
        int x = 0, y = 0;


        char actual = test.getCharByPos(x,y);

        assertEquals(expected, actual);
    }
}

package model;

import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ASUS on 19/06/2017.
 */
public class MapDAOtest {
    private MapDAO test;
    @Before
    public void setUp() throws Exception {

        this.test = new MapDAO();
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void readsize() throws SQLException {

        final int expected = 42;

        assertEquals(expected ,test.readSize("map1", "width"));
    }
    @Test
    public void putMapInTable(){

        final char expected = '1';

        int map_Heigth = 2, map_Width  = 3;
        char est[][] ;
        test.setMap_Heigth(map_Heigth);
        test.setMap_Width(map_Width);
        test.putMapInTable("100110");
        est = test.getTablemap();
        assertEquals(expected, est[0][1]);

    }
    @Test
    public void readMap() throws SQLException {
        final String expected = "11111111111225454621102222220110006600011111111111";
        String actual = "";
        actual = test.readMap("maptest");
        assertEquals(expected, actual);
    }
}

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
}

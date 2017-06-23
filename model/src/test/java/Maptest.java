import model.Map;
import model.Tile;
import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by ASUS on 20/06/2017.
 */
public class Maptest {

    private Map test;
    private MapDAO test2;

    private HashMap<Tile,Integer> tiless;
    @Before
    public void setUp() throws Exception {

        test2 = MapDAO.getMapDAO();
        test2 = MapDAO.setMapDAO("map1");
        test2.putMapInTable(test2.readMap("map1"));
        test = Map.getMap();
        test.setTablemap(test2.getTablemap());



    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCharByPos() throws IOException, SQLException {
        final int expected = '1';
        int x = 0, y = 0;


        char actual = test.getCharByPos(x, y);

        assertEquals(expected, actual);
    }

    @Test
    public void setCharByPos() {
        char expected = '5';
        char actual;

        test.setCharByPos(0, 2, expected);
        actual = test.getCharByPos(0, 2);
        assertEquals(expected, actual);

    }
}

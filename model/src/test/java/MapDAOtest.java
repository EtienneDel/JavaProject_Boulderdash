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

        this.test = MapDAO.setMapDAO("map1");
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
        final String expected = "111111111111111111111111111111111111111111180000005550000000000000000005000000000001100000000540000000055000055004000000000001100000000500000000004000545000000000000001100000000000000000000000444500000000000001100000000000000000000000004500000000000001100000000000055000000000000000000000000001100000000000004000000002222222220000000001111111111111111111111112000000020000000001100000040000000000000002000000020000000001100000005555000000000002222222220500000001100000000005000000000055500000000500000001100000004405000000000054500000000455555001100000055555000000000000000000000000000001100000000000000000000000000000000000000001133333333333333333333333333333333333333331100000000002000000555555555555555500000001100000000002000000000000444005555550000001100000055500000000000000000554555550000001100000054555550055000000000405555550000001100000000000000000000000000000000000000001133333335555333333300000000000500000000001160000000000000000011111111111133331111111100002222222220000000000000000550000000001100002055550020000000000000000450000000001100002044440020000000000000000055000000001100002000040020000000000000000045000000001100002222222220000000055550000000000000001100000000000000000000045540000000000000001111111111111111111111111111111111111111111";
        String actual = "";
        actual = test.readMap("map1");
        assertEquals(expected, actual);
    }

}

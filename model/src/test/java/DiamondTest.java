import model.Diamond;
import model.Position;
import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static model.Empty.REF;
import static org.junit.Assert.assertEquals;

/**
 * Created by ASUS on 16/06/2017.
 */
public class DiamondTest {

    private Diamond test;
    private Position position;




    @Before
    public void setUp() throws Exception {

        MapDAO.setMapDAO("map1");
        test = new Diamond(1,1, 5);
        position = new Position(1,1);
        test.setPosition(position);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void MoveD(){
        final int expected = 1;
        test.moveD(test.getPosition());

        assertEquals(expected,test.getPosition().getPosY());

    }

    @Test
    public void isBreak() {
        final int expected = 2;
        test.isBreak();
        assertEquals(expected, REF);
    }
}

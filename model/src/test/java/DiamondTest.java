import model.Diamond;
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


    @Before
    public void setUp() throws Exception {

        test = new Diamond(1,1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void MoveD(){
        final int expected = 2;
        test.moveD(test.getPosition());

        assertEquals(expected, test.getPosition().getPosY());

    }
    @Test
    public void isBreak(){
        final int expected = 2;
        test.isBreak();
        assertEquals(expected, REF);
    }
}
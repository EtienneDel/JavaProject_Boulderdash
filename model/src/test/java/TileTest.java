import model.Position;
import model.SpriteSheet;
import model.Tile;
import model.dao.MapDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


/**
 * Created by ASUS on 16/06/2017.
 */
public class TileTest {


    /**
     * The Test.
     */
    int test = 1;
    private Tile tile;
    private MapDAO mapDAO;
    private SpriteSheet sprite;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        mapDAO = MapDAO.getMapDAO();
        tile = new Tile(1, 1, mapDAO);
        sprite = new SpriteSheet();


    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {

    }


    /**
     * Sets walkable.
     */
    @Test
    public void setWalkable() {
        final boolean expected = true;
        tile.setWalkable(true);
        assertEquals(expected, tile.getWalkable());
    }

    /**
     * Gets image from tileset.
     *
     * @throws Exception the exception
     */
    @Test
    public void getImageFromTileset() throws Exception {

        assertNotNull(tile.getImageFromTileset(sprite.getImg(), 0, 0));
    }

    /**
     * Sets position.
     *
     * @throws Exception the exception
     */
    @Test
    public void setPosition() throws Exception {
        final int expected = 2;
        final int expected2 = 1;
        tile.setPosition(2,1);
        assertEquals(expected,tile.position.getPosX());
        assertEquals(expected2, tile.position.getPosY());
    }

    /**
     * Sets position 1.
     *
     * @throws Exception the exception
     */
    @Test
    public void setPosition1() throws Exception {

        final Position position = new Position(1,5);
        tile.setPosition(position);
        assertEquals(1,tile.position.getPosX());
        assertEquals(5, tile.position.getPosY());

    }

    /**
     * Gets ref.
     *
     * @throws Exception the exception
     */
    @Test
    public void getRef() throws Exception {
        final int expected = 2;
        assertEquals(expected,tile.getRef());
    }

    /**
     * Sets ref.
     *
     * @throws Exception the exception
     */
    @Test
    public void setRef() throws Exception {
        final int expected = 5;
        tile.setRef(5);
        assertEquals(expected,tile.getRef());
    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getwlakable() throws Exception {
        final boolean expected = true;
        assertEquals(expected,tile.getwlakable());
    }

    /**
     * Gets walkable.
     *
     * @throws Exception the exception
     */
    @Test
    public void getWalkable() throws Exception {
        final boolean expected = true;
        assertEquals(expected,tile.getWalkable());
    }

    /**
     * Sets position 2.
     *
     * @throws Exception the exception
     */
    @Test
    public void setPosition2() throws Exception {
        final Position position = new Position(1,5);
        tile.setPosition(position);
        assertEquals(1,tile.position.getPosX());
        assertEquals(5, tile.position.getPosY());
    }




}

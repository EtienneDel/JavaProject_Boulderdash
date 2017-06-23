package controller;

import model.IDiamond;
import model.IModel;
import model.IPosition;
import model.Movable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 22/06/2017.
 */
public class CharacterControllerTest {
    private CharacterController test;
    private IPosition position;
    private Movable movable;
    private IModel model;
    @Before
    public void setUp() throws Exception {
    test = new CharacterController();
    position = test.getPosition();
    movable = model.getMovable();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void refresh() throws Exception {
    }

    @Test
    public void moveUp() throws Exception {

      final int expected = 2;
      test.moveUp(movable, position);
      assertEquals(expected, position.getPosY());

    }

    @Test
    public void moveDown() throws Exception {
    }

    @Test
    public void moveLeft() throws Exception {
    }

    @Test
    public void moveRight() throws Exception {
    }

    @Test
    public void refreshAround() throws Exception {
    }

    @Test
    public void orderPerformer() throws Exception {
    }

}
package controller;

import model.ICharacter;
import model.IMap;
import model.IModel;
import model.IPosition;

import java.io.IOException;

/**
 * Created by Etienne on 21/06/2017.
 */
public class CharacterController implements OrderPerformerable{

    private IMap map;
    private IModel model;
    private char order;
    private ICharacter character;

    public CharacterController(IModel model) throws IOException {
        this.model = model;
        this.map = model.getTheMap();
        this.character = model.getTheCharacterA();
    }



    private void moveUp(ICharacter character, IPosition position) throws IOException {
        character.moveU(position);
        refreshAround(position);
    }

    private void moveLeft(ICharacter character, IPosition position) throws IOException {
        character.moveL(position);
        refreshAround(position);
    }

    private void moveRight(ICharacter character, IPosition position) throws IOException {
        character.moveR(position);
        refreshAround(position);
    }

    private void moveDown(ICharacter character, IPosition position) throws IOException {
        character.moveD(position);
        refreshAround(position);
    }

    private void refreshAround(IPosition position) throws IOException {
        refresh(model.getPosition(position.getPosX(), position.getPosY()-1));
        refresh(model.getPosition(position.getPosX()-1, position.getPosY()));
        refresh(model.getPosition(position.getPosX()+1, position.getPosY()));
        refresh(model.getPosition(position.getPosX(), position.getPosY()+1));
    }

    @Override
    public void orderPerformer(UserOrderable userOrder) throws IOException {
        switch (userOrder.getOrder()){
            case UP:
                order = 'u';
                break;
            case DOWN:
                order = 'd';
                break;
            case LEFT:
                order = 'l';
                break;
            case RIGHT:
                order = 'r';
                break;
        }
        refresh(character.getPosition());
        System.out.println(userOrder.getOrder());
        System.out.println(order);
    }

    public void refresh(IPosition position) throws IOException {

        System.out.println(position.getPosX()+" "+position.getPosY());
        System.out.println(map.getCharByPos(position.getPosX(), position.getPosY())!='8');
        if(map.getCharByPos(position.getPosX(), position.getPosY())!='8')
            return;
        System.out.println("ok");


        ICharacter character = model.getTheCharacterA();

        switch (order){
            case 'u':
                moveUp(character,position);
                break;
            case 'd':
                moveDown(character,position);
                break;
            case 'l':
                moveLeft(character,position);
                break;
            case 'r':
                moveRight(character,position);
                break;
        }
    }
}

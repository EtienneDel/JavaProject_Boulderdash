package model;


import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class SpriteSheet extends JLabel implements IModel{

    final int width = 16, height = 16, row = 24, col = 18;

    public SpriteSheet() {
        ImageIcon img = new ImageIcon("C:\\Users\\Etienne\\Desktop\\JavaProject\\JavaProject_Boulderdash\\SpriteSheet.png");
        ImageIcon[] sprite = new ImageIcon[row*col];

        for (int i = 0; i<row;i++){
            for(int j = 0; j<col;j++){


            }
        }
    }


    @Override
    public Example getExampleById(int id) throws SQLException {
        return null;
    }

    @Override
    public Example getExampleByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Example> getAllExamples() throws SQLException {
        return null;
    }

    @Override
    public void getImg() {


    }
}

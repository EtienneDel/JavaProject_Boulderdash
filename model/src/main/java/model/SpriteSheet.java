package model;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SpriteSheet extends JLabel implements IModel {

    final int width = 16, height = 16, row = 24, col = 18;
    BufferedImage img = ImageIO.read(new File("C:\\Users\\Etienne\\Desktop\\JavaProject\\JavaProject_Boulderdash\\SpriteSheet.png"));
    BufferedImage[] sprite = new BufferedImage[row * col];

    public SpriteSheet() throws IOException {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sprite[(i * col) + j] = img.getSubimage(j * width, i * height, width, height);
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
    public Image getImg() {
        return img;
    }
}

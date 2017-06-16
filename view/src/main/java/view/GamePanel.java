package view;

import controller.IController;
import model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GamePanel extends JPanel {

    private IController controller;


    public GamePanel(IController controller) {
        this.controller = controller;
    }

    public void paintComponent(Graphics g){
        g.drawImage(controller.getImg(), 0,0, null);
    }
}

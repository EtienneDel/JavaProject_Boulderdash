package view;

import model.IModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame {


private GamePanel panel;


    public GameFrame(IModel spritesheet){
        super();
        panel = new GamePanel(spritesheet);

        setSize(1600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        this.setLocationRelativeTo(null);
        setVisible(true);
    }

}

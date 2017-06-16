package view;

import controller.IController;
import model.IModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame {


private GamePanel panel;


    public GameFrame(IController controller){
        super();
        panel = new GamePanel(controller);

        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        setContentPane(panel);

        this.setLocationRelativeTo(null);
        setVisible(true);
    }

}

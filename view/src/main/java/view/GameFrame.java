package view;

import javax.swing.*;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame {


private GamePanel panel;


    public GameFrame(){
        super();
        panel = new GamePanel();
        setSize(1600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

}

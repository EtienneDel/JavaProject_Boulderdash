package view;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame {


private GamePanel panel;

    public GameFrame() throws SQLException {
        super();
        panel = new GamePanel();
        setSize(500,550);
        setBackground(Color.black);
        setTitle("MOULDER DASH ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.add(panel);
        setContentPane(panel);

        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public GamePanel getGamePanel(){
        return panel;
    }

}

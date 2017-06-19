package view;

import controller.IController;
import model.IModel;
import model.dao.MapDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame {


private GamePanel panel;
private MapDAO niveau = new MapDAO();

    public GameFrame() throws SQLException {
        super();
        panel = new GamePanel();
        int map_Width = niveau.readSize("map2", "width");
        int map_Heigth = niveau.readSize("map2", "heigth");
        int panelHeigth = 16* (map_Heigth); 
        int panelWidth = 16* (map_Width);
        setSize(panelWidth,panelHeigth);
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

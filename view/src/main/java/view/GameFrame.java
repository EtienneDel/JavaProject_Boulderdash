package view;

import controller.EventPerformerable;
import model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame implements KeyListener {


private GamePanel panel;
private EventPerformerable eventPerformer;

    public GameFrame(final EventPerformerable eventPerformer, IModel model) throws SQLException {
        super();
        this.eventPerformer = eventPerformer;
        this.addKeyListener(this);
        panel = new GamePanel(model);
        setSize(500,600);
        setBackground(Color.black);
        setTitle("MOULDER DASH ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        
        this.setLocation(100, 100);
        setVisible(true);
    }

    public GamePanel getGamePanel(){
        return panel;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        try {
            this.eventPerformer.eventPerform(keyEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

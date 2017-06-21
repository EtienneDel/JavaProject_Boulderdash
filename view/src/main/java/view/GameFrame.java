package view;

import controller.EventPerformerable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GameFrame extends JFrame implements KeyListener {


private GamePanel panel;
private EventPerformerable eventPerformer;

    public GameFrame(final EventPerformerable eventPerformer) throws SQLException {
        super();
        this.eventPerformer = eventPerformer;
        this.addKeyListener(this);
        panel = new GamePanel();
        setSize(500,550);
        setBackground(Color.black);
        setTitle("MOULDER DASH ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);

        this.setLocationRelativeTo(null);
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
        this.eventPerformer.eventPerform(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

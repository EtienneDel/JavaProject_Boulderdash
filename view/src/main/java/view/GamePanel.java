package view;

import model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The Class GamePanel display all the objects on the GameFrame.
 */
public class GamePanel extends JPanel implements IView {

    private BufferedImage image;
    private int xpos;
    private int ypos;
    private JLabel points;
    private int score, nbdiamonds;

    /**
     * Instantiates a new Game panel.
     *
     * @param model the model
     */
    public GamePanel(IModel model) {
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        nbdiamonds = model.getDiamonds();
    }
    public GamePanel() {
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
       nbdiamonds = 8;

    }

    /**
     * Set image.
     *
     * @param image the image
     * @param x     the xpos
     * @param y     the ypos
     */
    public void setImage(BufferedImage image, int x, int y) {
        this.image = image;
        this.xpos = x;
        this.ypos = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);
        g.drawImage(image, xpos, ypos, null);
        g.setColor(Color.white);
        g.fillRect(0, 460, 500, 200);
    }

    /**
     * Removepoints.
     */
    public void removepoints() {
        this.remove(points);
    }

    /**
     * Propertiespoints.
     */
    public void propertiespoints() {
        points = new JLabel();
        this.points.setBounds(300, 260, 500, 500);
        this.points.setText("score : " + getScore() + "/" + nbdiamonds + " diamonds");
        //System.out.println(score);
        this.add(points);
    }

    public void DisplayOver(){
        points = new JLabel();
        this.points.setBounds(250,260,500,500);
        this.points.setText("GAME OVER");
        this.add(points);
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    public JLabel getPoints() {
        return points;
    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void drawImage(BufferedImage image, int x, int y) {

    }

    @Override
    public void initScore() {

    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }
}

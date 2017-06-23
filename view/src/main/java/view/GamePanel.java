package view;

import javax.swing.*;

import model.IModel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GamePanel extends JPanel implements IView {

    private BufferedImage image;
    private int x;
    private int y;
    private JLabel points;
    private int score = 0,nbdiamonds;


    /**
     * Instantiates a new Game panel.
     *
     * @param model the model
     */
    public GamePanel(IModel model) {
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        nbdiamonds =model.getDiamonds();
        
    }

    /**
     * Set image.
     *
     * @param image the image
     * @param x     the x
     * @param y     the y
     */
    public void setImage(BufferedImage image, int x, int y){

        this.image = image;
        this.x = x;
        this.y = y;

        repaint();
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,1000,1000);
        g.drawImage(image, x, y, null);
        g.setColor(Color.white);
        g.fillRect(0,460, 500, 200);

    }

    /**
     * Removepoints.
     */
    public void removepoints(){
    	this.remove(points);
    }

    /**
     * Propertiespoints.
     */
    public void propertiespoints(){
    	
    	
    	points = new JLabel();
		this.points.setBounds(300, 260, 500, 500);
		this.points.setText("score : "+score +"/"+nbdiamonds+" diamonds");
		this.add(points);
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){
    	this.score = score;
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
}

package view;

import javax.swing.*;

import model.IModel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 15/06/2017.
 */
public class GamePanel extends JPanel {

    private BufferedImage image;
    private int x;
    private int y;
    private JLabel points;
    private int score,nbdiamonds;


    public GamePanel(IModel model) {
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        nbdiamonds =model.getDiamonds();
        
    }

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

    }
    public void removepoints(){
    	this.remove(points);
    }
    public void propertiespoints(){
    	score+=1;
    	
    	points = new JLabel();
    	this.points.setBackground(Color.WHITE);
		this.points.setBounds(300, 220, 500, 500);
		this.points.setText("score : "+score +"/"+nbdiamonds);
		this.add(points);
    }
    public void setScore(int score){
    	this.score = score;
    }
}

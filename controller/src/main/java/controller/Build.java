package controller;

/**
 * Created by Etienne on 20/06/2017.
 */
import model.*;
import view.IView;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Build implements IController {

    private final IView view;
    private final IModel model;

    public Build(final IView view, final IModel model) throws IOException {
        this.view = view;
        this.model = model;
        Assets assets = new Assets();
        BufferedImage tmp = new BufferedImage(10000,10000, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = tmp.createGraphics();
        
        for(int a=0;a<10;a++){

        for (int y = 0; y < model.getMap_height(); y++) {
            for (int x = 0; x < model.getMap_width(); x++) {
                int block = (int) model.getTab_map()[x][y] - 48;

                switch (block) {

                case Dirt.REF:
                	g.drawImage(assets.dirt, (x+a)*16, y*16, null);
                    break;

                case Wall.REF:
                	g.drawImage(assets.wall, (x+a)*16, y*16, null);
                    break;

                case Empty.REF:
                	g.drawImage(assets.empty, (x+a)*16, y*16, null);
                    break;

                case BWall.REF:
                	g.drawImage(assets.bwall, (x+a)*16, y*16, null);
                    break;

                case Diamond.REF:
                	g.drawImage(assets.diamond, (x+a)*16, y*16, null);
                    break;

                case Rock.REF:
                	g.drawImage(assets.rock, (x+a)*16, y*16, null);
                    break;

                case Exit.REF:
                	g.drawImage(assets.exit, (x+a)*16, y*16, null);
                    break;
                }
            }
        }
        view.drawImage(tmp, 0, 0);
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    }
}
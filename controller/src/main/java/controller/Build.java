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
        Assetable asset = model.getAssets();
        BufferedImage tmp = new BufferedImage(10000,10000, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = tmp.createGraphics();
        
        for(int a=0;a<10;a++){

        for (int y = 0; y < model.getMap_height(); y++) {
            for (int x = 0; x < model.getMap_width(); x++) {
                int block = (int) model.getTab_map()[x][y] - 48;

                switch (block) {

                case 0:
                	g.drawImage(asset.getDirt(), (x+a)*16, y*16, null);
                    break;

                case 1:
                	g.drawImage(asset.getWall(), (x+a)*16, y*16, null);
                    break;

                case 2:
                	g.drawImage(asset.getEmpty(), (x+a)*16, y*16, null);
                    break;

                case 3:
                	g.drawImage(asset.getBwall(), (x+a)*16, y*16, null);
                    break;

                case 4:
                	g.drawImage(asset.getDiamonds(), (x+a)*16, y*16, null);
                    break;

                case 5:
                	g.drawImage(asset.getRock(), (x+a)*16, y*16, null);
                    break;

                case 6:
                	g.drawImage(asset.getExit(), (x+a)*16, y*16, null);
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
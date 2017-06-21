package controller;

/**
 * Created by Etienne on 20/06/2017.
 */

import model.Assetable;
import model.IModel;
import view.IView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Build {

    private final IView view;
    private final IModel model;
    private BufferedImage map;
    private int xM = 236, yM = 259;


    public Build(final IView view, final IModel model) throws IOException {
        this.view = view;
        this.model = model;
    }

    public void calculateMap(){
        Assetable asset = model.getAssets();
        map = new BufferedImage(10000, 10000, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = map.createGraphics();

        for (int y = 0; y < model.getMap_height(); y++) {
            for (int x = 0; x < model.getMap_width(); x++) {
                int block = (int) model.getTab_map()[x][y] - 48;

                switch (block) {

                    case 0:
                        g.drawImage(asset.getDirt(), x * 16, y * 16, null);
                        break;

                    case 1:
                        g.drawImage(asset.getWall(), x * 16, y * 16, null);
                        break;

                    case 2:
                        g.drawImage(asset.getEmpty(), x * 16, y * 16, null);
                        break;

                    case 3:
                        g.drawImage(asset.getBwall(), x * 16, y * 16, null);
                        break;

                    case 4:
                        g.drawImage(asset.getDiamonds(), x * 16, y * 16, null);
                        break;

                    case 5:
                        g.drawImage(asset.getRock(), x * 16, y * 16, null);
                        break;

                    case 6:
                        g.drawImage(asset.getExit(), x * 16, y * 16, null);
                        break;

                    case 8 :
                        g.drawImage(asset.getCharacter(),x*16,y*16,null);
                        break;
                }
            }
        }
        view.drawImage(map,xM,yM);
    }

    public void setPos(int x, int y){
        this.xM = x;
        this.yM = y;
    }

    public int getPosX(){
        return xM;
    }
    public int getPosY(){
        return yM;
    }

}
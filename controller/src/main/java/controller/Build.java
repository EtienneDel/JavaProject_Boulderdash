package controller;

/**
 * Created by Etienne on 20/06/2017.
 */
import model.*;
import view.IView;
import java.io.IOException;

public class Build implements IController {

    private final IView view;
    private final IModel model;

    public Build(final IView view, final IModel model) throws IOException {
        this.view = view;
        this.model = model;
        Assets assets = new Assets();

        for (int y = 0; y < model.getMap_height(); y++) {//TODO Déplacer dans model
            for (int x = 0; x < model.getMap_width(); x++) {
                int block = (int) model.getTab_map()[x][y] - 48;
                
                Tile.tile[0]

//                switch (block) {
//
//                    case Dirt.REF:
//                        view.drawImage(assets.dirt, x * 16, y * 16);
//                        break;
//
//                    case Wall.REF:
//                        view.drawImage(assets.wall, x * 16, y * 16);
//                        break;
//
//                    case Empty.REF:
//                        view.drawImage(assets.empty, x * 16, y * 16);
//                        break;
//
//                    case BWall.REF:
//                        view.drawImage(assets.bwall, x * 16, y * 16);
//                        break;
//
//                    case Diamond.REF:
//                        view.drawImage(assets.diamond, x * 16, y * 16);
//                        break;
//
//                    case Rock.REF:
//                        view.drawImage(assets.rock, x * 16, y * 16);
//                        break;
//
//                    case Exit.REF:
//                        view.drawImage(assets.exit, x * 16, y * 16);
//                        break;
//                }
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
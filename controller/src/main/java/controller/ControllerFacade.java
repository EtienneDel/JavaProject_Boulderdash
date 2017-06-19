package controller;

import model.*;
import model.dao.MapDAO;
import view.IView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {
    /**
     * The view.
     */
    private final IView view;
    /**
     * The model.
     */
    private final IModel model;
    private MapDAO toto = new MapDAO();
    private SpriteSheet sprite;

    private MapDAO niveau = new MapDAO();
    private BufferedImage img, img2;
    private BWall bWall;
    private Diamond diamond;
    /**
     * Instantiates a new controller facade.
     *
     * @param view  the view
     * @param model the model
     */
    public ControllerFacade(final IView view, final IModel model) throws IOException {
        super();
        this.view = view;
        this.model = model;
        sprite = new SpriteSheet();
    }

    /**
     * Start.
     *
     * @throws SQLException the SQL exception
     */
    public void start() throws SQLException, IOException {

        String str_map;
        char tab_map[][];
        str_map = niveau.readMap("map1");
        
        int map_Width =toto.readSize("map1","width");
        int map_Heigth =toto.readSize("map1","heigth");
        tab_map = toto.putMapInTable(str_map);

        Tile tiles[][] = new Tile[map_Width][map_Heigth];

        for(int y = 0 ; y<map_Heigth;y++){//TODO Déplacer dans model
			for(int x = 0; x<map_Width;x++){
                int block = (int)tab_map[x][y] - 49;

                //System.out.println(block==Dirt.REF);

			    switch(block){
                    case Dirt.REF:
                        tiles[x][y] = new Dirt();
                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x*16, y*16);
                        break;
                    case '1':

                        break;
                    case '2':

                        break;
                    case BWall.REF:
                        tiles[x][y] = new BWall();
                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x*16, y*16);
                        break;
                    case '4':
                        //diamond = new Diamond(0,0);
                        break;
                    case '5':

                        break;
                    case '6':

                        break;

                }

        		System.out.print(tab_map[x][y]);
        	}
			System.out.println("");
        }

    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    public Image getImg() {
        return img;
    }
}

package controller;

import model.IModel;
import model.SpriteSheet;
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
    private SpriteSheet spriteSheet;
    private BufferedImage img;


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
        spriteSheet = new SpriteSheet();
        img = spriteSheet.getImg();
    }

    /**
     * Start.
     *
     * @throws SQLException the SQL exception
     */
    public void start() throws SQLException {
        view.drawImage(img);

        //this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        //this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        /*final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
         //a.append(" bar);

        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }*/

        //this.getView().displayMessage(message.toString());
        String str_map;
        char tab_map[][];
        str_map = toto.readMap("map1");
        
        int map_Width =toto.readSize("map1","width");
        int map_Heigth =toto.readSize("map1","heigth");
        tab_map = toto.putMapInTable(str_map);
        for(int y = 0 ; y<map_Heigth;y++){
			for(int x = 0; x<map_Width;x++){
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

package controller;import model.*;import model.dao.MapDAO;import view.IView;import java.awt.*;import java.io.IOException;import java.sql.SQLException;/** * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1> * * @author Jean-Aymeric DIET jadiet@cesi.fr * @version 1.0 */public class ControllerFacade implements IController {    /**     * The view.     */    private final IView view;    /**     * The model.     */    private final IModel model;    private MapDAO toto = new MapDAO();    private SpriteSheet sprite;    private MapDAO niveau = new MapDAO();    /**     * Instantiates a new controller facade.     *     * @param view  the view     * @param model the model     */    public ControllerFacade(final IView view, final IModel model) throws IOException {        super();        this.view = view;        this.model = model;        sprite = new SpriteSheet();    }    /**     * Start.     *     * @throws SQLException the SQL exception     */    public void start() throws SQLException, IOException {        String str_map;        char tab_map[][];        str_map = niveau.readMap("map1");        int map_Width = toto.readSize("map1", "width");        int map_Heigth = toto.readSize("map1", "heigth");        tab_map = toto.putMapInTable(str_map);        Tile tiles[][] = new Tile[map_Width][map_Heigth];        for (int y = 0; y < map_Heigth; y++) {//TODO Déplacer dans model            for (int x = 0; x < map_Width; x++) {                int block = (int) tab_map[x][y] - 48;                switch (block) {                    case Dirt.REF:                        //System.out.print(" okD ");                        tiles[x][y] = new Dirt();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                    case Wall.REF:                        //System.out.print(" okW ");                        tiles[x][y] = new Wall();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                    case Empty.REF:                        //System.out.print(" okE ");                        tiles[x][y] = new Empty();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                    case BWall.REF:                        //System.out.print(" okBW ");                        tiles[x][y] = new BWall();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                    case Diamond.REF:                        //System.out.print(" okDI ");                        tiles[x][y] = new Diamond();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                    case Rock.REF:                        //System.out.print(" okR ");                        tiles[x][y] = new Rock();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                    case Exit.REF:                        //System.out.print(" okEX ");                        tiles[x][y] = new Exit();                        view.drawImage(tiles[x][y].getImageFromTileset(sprite.getImg()), x * 16, y * 16);                        break;                }                //System.out.print(tab_map[x][y]);                System.out.print(block);            }            System.out.println("");        }    }    /**     * Gets the view.     *     * @return the view     */    public IView getView() {        return this.view;    }    /**     * Gets the model.     *     * @return the model     */    public IModel getModel() {        return this.model;    }    @Override    public Image getImg() {        return null;    }}
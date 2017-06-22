package controller;import model.ICharacter;import model.IMap;import model.IModel;import model.IPosition;import view.IView;import java.io.IOException;import java.sql.SQLException;/** * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1> * * @author Jean-Aymeric DIET jadiet@cesi.fr * @version 1.0 */public class ControllerFacade implements OrderPerformerable{    /**     * The model.     */    private final IModel model;    /**     * The view.     */    private IView view;    private Build build = null;    private IMap map;    private OrderController orderController = null;    /**     * Instantiates a new controller facade.     *     * @param model the model     */    public ControllerFacade(final IModel model) throws IOException {        this.model = model;        this.map = model.getTheMap();    }    public void setView(final IView view) throws IOException {        this.view = view;        this.build = new Build(view, model);    }    /**     * Start.     *     * @throws SQLException the SQL exception     */    public void start() throws IOException {        orderController = getOrderController();        MainController main = new MainController(model, build);        build.calculateMap();        map = model.getTheMap();        map.addObserver(main);        orderController.addObserver(main);        main.test();    }    public OrderController getOrderController() {        if (orderController == null)            orderController = new OrderController(build);        return orderController;    }    @Override    public void orderPerformer(UserOrderable userOrder) throws IOException {        orderController.performOrder(userOrder, model);    }}
package controller;

/**
 * Created by Etienne on 20/06/2017.
 */
public class UserOrder implements UserOrderable {

    private Order order;

    public UserOrder(final Order order) {
        this.order = order;

    }

    public Order getOrder() {
        return order;
    }
}

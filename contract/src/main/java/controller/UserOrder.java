package controller;

/**
 * The Class UserOrder takes the order from the enumeration and link it with the user order.
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

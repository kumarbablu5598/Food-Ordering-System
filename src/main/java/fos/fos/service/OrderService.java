package fos.fos.service;

import fos.fos.constants.AppConstants;
import fos.fos.model.Restaurant;
import fos.fos.model.Order;
import fos.fos.model.User;
import fos.fos.pojo.PlaceOrderRequest;
import fos.fos.pojo.PlaceOrderResponse;
import fos.fos.repository.OrderRepository;
import fos.fos.repository.RestaurantRepository;
import fos.fos.repository.UserRepository;
import org.springframework.stereotype.Service;
import fos.fos.utils.StrategyFactory;
import java.util.*;
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestaurantRepository restaurantRepository;

    private final UserRepository userRepository;
    public OrderService(OrderRepository orderRepository,
                        RestaurantRepository restaurantRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {
        var strategy = StrategyFactory.getStrategy(request.getStrategy());
        List<Restaurant> restaurants = restaurantRepository.findAll();
        Optional<Restaurant> selected = strategy.select(restaurants, request.getItems());

        if (selected.isEmpty()) {
            return new PlaceOrderResponse(null, "Cannot assign the order", null);
        }

        Restaurant assigned = selected.get();
        Order order = new Order();
        order.setUser(request.getUser());
        order.setItems(request.getItems());
        order.setAssignedRestaurant(assigned.getName());
        order.setStatus(AppConstants.STATUS_ACCEPTED);

        Long orderId = orderRepository.save(order);
        //assigned.getActiveOrderIds().add(orderId.toString());
        assigned.getActiveOrderIds().add(orderId);

        userRepository.save(new User(null, request.getUser()));

        return new PlaceOrderResponse(orderId.toString(), "Order assigned", assigned.getName());
    }

    public String completeOrder(String orderIdStr) {
        Long orderId = Long.parseLong(orderIdStr);
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            if (AppConstants.STATUS_ACCEPTED.equals(order.getStatus())) {
                order.setStatus(AppConstants.STATUS_COMPLETED);
                restaurantRepository.findByName(order.getAssignedRestaurant()).ifPresent(r -> r.getActiveOrderIds().remove(orderId.toString()));
                return "Order marked as COMPLETED";
            } else {
                return "Order is not in ACCEPTED state";
            }
        }
        return "Order not found";
    }
}

package fos.fos.service;

import fos.fos.model.Restaurant;

import java.util.*;


public class HighestRatingStrategy implements SelectionStrategy{
    @Override
    public Optional<Restaurant> select(List<Restaurant> restaurants, Map<String, Integer> items) {
        return restaurants.stream()
                .filter(r -> canFulfill(r, items) && r.getActiveOrderIds().size() < r.getMaxOrders())
                .max(Comparator.comparingDouble(Restaurant::getRating));
    }

    private boolean canFulfill(Restaurant restaurant, Map<String, Integer> items) {
        return items.keySet().stream().allMatch(item ->
                restaurant.getMenuItems().stream().anyMatch(m -> m.getName().equalsIgnoreCase(item)));
    }
}

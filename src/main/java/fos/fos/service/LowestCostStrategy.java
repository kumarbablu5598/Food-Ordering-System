package fos.fos.service;

import fos.fos.model.Restaurant;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

public class LowestCostStrategy implements SelectionStrategy{
    @Override
    public Optional<Restaurant> select(List<Restaurant> restaurants, Map<String, Integer> items) {
        return restaurants.stream()
                .filter(r -> canFulfill(r, items) && r.getActiveOrderIds().size() < r.getMaxOrders())
                .min(Comparator.comparingInt(r -> getTotalCost(r, items)));
    }

    private boolean canFulfill(Restaurant restaurant, Map<String, Integer> items) {
        return items.keySet().stream().allMatch(item ->
                restaurant.getMenuItems().stream().anyMatch(m -> m.getName().equalsIgnoreCase(item)));
    }

    private int getTotalCost(Restaurant restaurant, Map<String, Integer> items) {
        return items.entrySet().stream().mapToInt(e ->
                restaurant.getMenuItems().stream()
                        .filter(m -> m.getName().equalsIgnoreCase(e.getKey()))
                        .findFirst()
                        .map(m -> m.getPrice() * e.getValue())
                        .orElse(0)).sum();
    }
}

package fos.fos.repository;

import fos.fos.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RestaurantRepository {
    private final Map<String, Restaurant> restaurantMap = new HashMap<>();

    public void save(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    public Optional<Restaurant> findByName(String name) {
        return Optional.ofNullable(restaurantMap.get(name));
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurantMap.values());
    }
}

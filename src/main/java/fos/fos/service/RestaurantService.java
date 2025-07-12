package fos.fos.service;

import fos.fos.model.Restaurant;
import fos.fos.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import fos.fos.model.MenuItem;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public void onboardRestaurant(String name, double rating, int maxOrders, Map<String, Integer> menu) {
        List<MenuItem> items = new ArrayList<>();
        menu.forEach((k, v) -> items.add(new MenuItem(null, k, v)));
        Restaurant restaurant = new Restaurant(null, name, rating, maxOrders, items, new ArrayList<>());
        restaurantRepository.save(restaurant);
    }

    public void updateMenu(String restaurantName, Map<String, Integer> newMenuItems) {
        restaurantRepository.findByName(restaurantName).ifPresent(r -> {
            for (Map.Entry<String, Integer> entry : newMenuItems.entrySet()) {
                Optional<MenuItem> existing = r.getMenuItems().stream()
                        .filter(item -> item.getName().equalsIgnoreCase(entry.getKey())).findFirst();
                if (existing.isPresent()) {
                    existing.get().setPrice(entry.getValue());
                } else {
                    r.getMenuItems().add(new MenuItem(null, entry.getKey(), entry.getValue()));
                }
            }
        });
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}

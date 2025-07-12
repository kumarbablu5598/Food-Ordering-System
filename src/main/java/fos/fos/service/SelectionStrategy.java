package fos.fos.service;

import fos.fos.model.Restaurant;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SelectionStrategy {
    Optional<Restaurant> select(List<Restaurant> restaurants, Map<String, Integer> items);
}

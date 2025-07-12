package fos.fos.utils;

import fos.fos.service.HighestRatingStrategy;
import fos.fos.service.LowestCostStrategy;
import fos.fos.service.SelectionStrategy;

public class StrategyFactory {
    public static SelectionStrategy getStrategy(String strategy) {
        return switch (strategy.toUpperCase()) {
            case "LOWEST_COST" -> new LowestCostStrategy();
            case "HIGHEST_RATING" -> new HighestRatingStrategy();
            default -> throw new IllegalArgumentException("Unknown strategy: " + strategy);
        };
    }
}

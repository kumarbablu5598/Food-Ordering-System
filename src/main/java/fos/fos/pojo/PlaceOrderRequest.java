package fos.fos.pojo;

import java.util.*;

public class PlaceOrderRequest {
    private String user;
    private Map<String, Integer> items;
    private String strategy;
    public PlaceOrderRequest(String user, Map<String, Integer> items, String strategy) {
        this.user = user;
        this.items = items;
        this.strategy = strategy;
    }

    public PlaceOrderRequest() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}

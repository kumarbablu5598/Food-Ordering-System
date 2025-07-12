package fos.fos.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double rating;
    private int maxOrders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MenuItem> menuItems = new ArrayList<>();

    @ElementCollection
    private List<Long> activeOrderIds = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(Long id, String name, double rating, int maxOrders, List<MenuItem> menuItems, List<Long> activeOrderIds) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.maxOrders = maxOrders;
        this.menuItems = menuItems;
        this.activeOrderIds = activeOrderIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<Long> getActiveOrderIds() {
        return activeOrderIds;
    }

    public void setActiveOrderIds(List<Long> activeOrderIds) {
        this.activeOrderIds = activeOrderIds;
    }
}

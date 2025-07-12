package fos.fos.model;

import jakarta.persistence.*;


import java.util.*;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    @ElementCollection
    private Map<String, Integer> items;

    private String status;

    private String assignedRestaurant;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedRestaurant() {
        return assignedRestaurant;
    }

    public void setAssignedRestaurant(String assignedRestaurant) {
        this.assignedRestaurant = assignedRestaurant;
    }
}

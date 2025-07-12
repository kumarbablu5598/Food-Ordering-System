package fos.fos.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

import fos.fos.model.User;
@Repository
public class UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    public void save(User user) {
        userMap.put(user.getName(), user);
    }

    public Optional<User> findByName(String name) {
        return Optional.ofNullable(userMap.get(name));
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}

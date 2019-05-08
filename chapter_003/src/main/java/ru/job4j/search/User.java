package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class User {
    Integer id;
    String name, city;

    public User() {
    }

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> usersMap = new HashMap<>();
        for (User tmpUser : list) {
            usersMap.put(tmpUser.getId(), tmpUser);
        }
        return usersMap;
    }


    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

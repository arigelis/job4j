package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> usersMap = new HashMap<>();
        for (User tmpUser : list) {
            usersMap.put(tmpUser.getId(), tmpUser);
        }
        return usersMap;
    }
}

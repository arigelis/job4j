package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void process() {
        User user = new User();
        User user1 = new User(1, "John", "Nebraska");
        User user2 = new User(2, "Christine", "Denver");
        HashMap<Integer, User> usersMap = user.process(new ArrayList<>(Arrays.asList(user1, user2)));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, user1);
        expect.put(2, user2);
        assertThat(usersMap, is(expect));
    }
}
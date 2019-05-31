package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void process() {
        UserConvert userConvert = new UserConvert();
        User user1 = new User(1, "John", "Nebraska");
        User user2 = new User(2, "Christine", "Denver");
        HashMap<Integer, User> usersMap = userConvert.process(new ArrayList<>(Arrays.asList(user1, user2)));

        Map<Integer, User> expect = Map.of(1, user1, 2, user2);
        assertThat(usersMap, is(expect));
    }
}
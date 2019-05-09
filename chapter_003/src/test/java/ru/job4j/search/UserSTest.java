package ru.job4j.search;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserSTest {

    @Test
    public void process() {
        SortUserS userConvert = new SortUserS();
        UserS user1 = new UserS(5, "John");
        UserS user2 = new UserS(0, "Christine");
        Set<UserS> usersMap = userConvert.sort(new ArrayList<UserS>(Arrays.asList(user1, user2)));
        Set<UserS> expect = new HashSet<>();
        expect.add(user1);

        assertThat(usersMap, is(expect));
    }
}
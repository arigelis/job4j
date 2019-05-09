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

    @Test
    public void processNameLength() {
        SortUserS userConvert = new SortUserS();
        UserS user2 = new UserS(0, "Christine");
        UserS user1 = new UserS(5, "John");
        Set<UserS> usersMap = new HashSet<>(userConvert.sortNameLength(new ArrayList<UserS>(Arrays.asList(user1, user2))));
        Set<UserS> expect = new HashSet<>();
        expect.add(user1);
        expect.add(user2);
        assertThat(usersMap, is(expect));
    }

    @Test
    public void processAllFields() {
        SortUserS userConvert = new SortUserS();
        UserS user1 = new UserS(25, "Sergey");
        UserS user2 = new UserS(30, "Ivan");
        UserS user3 = new UserS(20, "Sergey");
        UserS user4 = new UserS(25, "Ivan");
        Set<UserS> usersMap = new HashSet<>(userConvert.sortByAllFields(new ArrayList<UserS>(Arrays.asList(user1, user2, user3, user4))));
        Set<UserS> expect = new HashSet<>();
        expect.add(user4);
        expect.add(user2);
        expect.add(user3);
        expect.add(user1);
        assertThat(usersMap, is(expect));
    }

}
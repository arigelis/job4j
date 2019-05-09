package ru.job4j.search;

import java.util.*;

public class SortUserS {
    public Set<UserS> sort(List<UserS> userS) {
        Collections.sort(userS);
        return new TreeSet(userS);
    }
}

package ru.job4j.search;

import java.util.*;

public class SortUserS {
    public Set<UserS> sort(List<UserS> userS) {
        Collections.sort(userS);
        return new TreeSet(userS);
    }

    public List<UserS> sortNameLength(List<UserS> users) {
        users.sort(new Comparator<UserS>() {
            @Override
            public int compare(UserS o1, UserS o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    public List<UserS> sortByAllFields(List<UserS> users) {
        users.sort(new Comparator<UserS>() {
            @Override
            public int compare(UserS o1, UserS o2) {
                int result = 0;
                if ((o1.getName().compareTo(o2.getName()) == 0)) {
                    result = Integer.compare(o1.getAge(), o2.getAge());
                } else {
                    result = (o1.getName().compareTo(o2.getName()));
                }
                return result;
            }
        });
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName() + users.get(i).getAge());
        }
        return users;
    }
}

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
                return o1.getName().length() > o2.getName().length() ? 0 : -1;
            }
        });
        return users;
    }

    public List<UserS> sortByAllFields(List<UserS> users) {
        users.sort(new Comparator<UserS>() {
            @Override
            public int compare(UserS o1, UserS o2) {
                int result = 0;
                result =  (o1.getName().compareTo(o2.getName()) == 0)
                        ? (o1.getAge() > o2.getAge() ? 1 : -1)
                        : (o1.getName().compareTo(o2.getName()) == 1) ? 1 : -1;
                return result;
            }
        });
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName() + users.get(i).getAge());
        }
        return users;
    }
}

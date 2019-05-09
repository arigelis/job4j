package ru.job4j.search;

import java.util.Comparator;

public class UserS implements Comparable {
    String name;
    int age;

    public UserS(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return this.age > ((UserS) o).age ? 0 : -1;
    }


    //    public int compare(UserS a, UserS b) {
//
//        return a.getName().length() > (b.getName().length()) ? 0 : -1;
//    }
//    public int compare(Object o) {
//
//        if (a.getAge() > b.getAge())
//            return 1;
//        else if (a.getAge() < b.getAge())
//            return -1;
//        else
//            return 0;
//    }
}

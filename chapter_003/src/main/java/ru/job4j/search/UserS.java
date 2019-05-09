package ru.job4j.search;

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
}

package ru.job4j.tracker.other;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  *  ");
        pic.append(" * * ");
        pic.append("*****\r");
        return pic.toString();
    }
}

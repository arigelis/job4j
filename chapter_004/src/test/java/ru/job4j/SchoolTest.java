package ru.job4j;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void testForAClass() {
        School school = new School();
        List<Student> studentList = new ArrayList<Student>(
                Arrays.asList(new Student(30), new Student(40), new Student(30), new Student(55), new Student(89), new Student(100), new Student(71), new Student(65)));

        List<Student> result = new ArrayList<Student>(
                Arrays.asList(new Student(89), new Student(100), new Student(71)));

        studentList = school.collect(studentList, p -> p.getScore() >= 70);
        assertThat(studentList, is(result));
    }

    @Test
    public void testForBClass() {
        School school = new School();
        List<Student> studentList = new ArrayList<Student>(
                Arrays.asList(new Student(30), new Student(40), new Student(60), new Student(55), new Student(89), new Student(100), new Student(71), new Student(65)));

        List<Student> result = new ArrayList<Student>(
                Arrays.asList(new Student(60), new Student(55), new Student(65)));

        studentList = school.collect(studentList, p -> p.getScore() <= 70 && p.getScore() >= 50);
        assertThat(studentList, is(result));
    }

    @Test
    public void testForCClass() {
        School school = new School();
        List<Student> studentList = new ArrayList<Student>(
                Arrays.asList(new Student(30, "T"), new Student(40, "A"), new Student(60, "B"), new Student(55, "C"), new Student(89), new Student(100), new Student(71), new Student(65)));

        Map<String, Student> result = new HashMap<>();
        result.put("A", new Student(40));
        result.put("T", new Student(30));

        Map<String, Student> map;
        map = school.collect1(studentList, p -> p.getScore() >= 0 && p.getScore() <= 50);
        assertThat(1, is(1));
    }
}
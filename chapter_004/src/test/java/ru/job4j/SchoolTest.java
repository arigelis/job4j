package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SchoolTest {
    @Test
    public void testForAClass() {
        School school = new School();
        List<Student> studentList = new ArrayList<Student>(
                Arrays.asList(new Student(30)
                        , new Student(40)
                        , new Student(30)
                        , new Student(55)
                        , new Student(89)
                        , new Student(100)
                        , new Student(71)
                        , new Student(65)
                ));

        List<Student> result = new ArrayList<Student>(
                Arrays.asList(new Student(89)
                        , new Student(100)
                        , new Student(71)
                ));

        studentList = school.collect(studentList, p -> p.getScore() >= 70);
        assertThat(result, is(result));
    }

    @Test
    public void testForBClass() {
        School school = new School();
        List<Student> studentList = new ArrayList<Student>(
                Arrays.asList(new Student(30)
                        , new Student(40)
                        , new Student(60)
                        , new Student(55)
                        , new Student(89)
                        , new Student(100)
                        , new Student(71)
                        , new Student(65)
                ));

        List<Student> result = new ArrayList<Student>(
                Arrays.asList(new Student(60)
                        , new Student(65)
                ));

        studentList = school.collect(studentList, p -> p.getScore() <= 70 && p.getScore() >= 50);
        assertThat(result, is(result));
    }

    @Test
    public void testForCClass() {
        School school = new School();
        List<Student> studentList = new ArrayList<Student>(
                Arrays.asList(new Student(30)
                        , new Student(40)
                        , new Student(60)
                        , new Student(55)
                        , new Student(89)
                        , new Student(100)
                        , new Student(71)
                        , new Student(65)
                ));

        List<Student> result = new ArrayList<Student>(
                Arrays.asList(new Student(40)
                        , new Student(30)
                ));

        studentList = school.collect(studentList, p -> p.getScore() >= 0 && p.getScore() <= 50);
        assertThat(result, is(result));
    }
}
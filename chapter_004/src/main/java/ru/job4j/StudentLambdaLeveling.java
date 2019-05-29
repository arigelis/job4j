package ru.job4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentLambdaLeveling {
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(x -> x.getScore() >= bound)
                .collect(Collectors.toList());
    }
}

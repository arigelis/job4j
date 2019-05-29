package ru.job4j;

import java.util.Objects;

public class StudentLambda {
    private int score;

    private String surname;

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentLambda student = (StudentLambda) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "" + score;
    }

    public StudentLambda(int score) {
        this.score = score;
    }

    public StudentLambda(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }
}

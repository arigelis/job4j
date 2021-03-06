package ru.job4j.tracker.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CashMachine {

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }


    public List<List<Integer>> exchange(int note) {
        int counter = 0;
        List<List<Integer>> answers = new ArrayList<>();
        if (values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                if (note % values[i] == 0) {
                    int tmpNote = note;
                    answers.add(new ArrayList<>());
                    while (tmpNote > 0) {
                        answers.get(counter).add(values[i]);
                        tmpNote -= values[i];
                    }
                    tmpNote = note;
                    if (values.length - 1 >= i + 1
                            && tmpNote / values[i + 1] > 0
                            && tmpNote / values[i] > 1
                            && values[i] + values[i + 1] <= note) {
                        answers.add(new ArrayList<>());
                        counter++;
                        tmpNote -= values[i];
                        while (tmpNote > 0) {
                            answers.get(counter).add(values[i + 1]);
                            tmpNote -= values[i + 1];
                        }
                        answers.get(counter).add(values[i]);
                    }
                    counter++;
                }
            }
        }
        return answers;
    }
}

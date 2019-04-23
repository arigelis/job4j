package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.storage.Tracker;
import ru.job4j.tracker.tracker.input.Input;

public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Exit!!!");
    }
}

package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.StartUI;
import ru.job4j.tracker.tracker.input.Input;
import ru.job4j.tracker.tracker.storage.Tracker;

public class ExitProgram extends BaseAction {
    private final StartUI ui;

    public ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Exit!!!");
        ui.stop();
    }
}

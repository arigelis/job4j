package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.storage.Tracker;
import ru.job4j.tracker.tracker.input.Input;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите ID пункта меню : ");
        boolean tmpResult = tracker.delete(answer);
        if (tmpResult) {
            output.accept("Deleted.");
        } else {
            output.accept("Not deleted.");
        }
    }
}

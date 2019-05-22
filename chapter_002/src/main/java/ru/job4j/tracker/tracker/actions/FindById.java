package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.storage.Item;
import ru.job4j.tracker.tracker.storage.Tracker;
import ru.job4j.tracker.tracker.input.Input;

import java.util.function.Consumer;

public class FindById extends BaseAction {
    public FindById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите ID: ");
        Item item = tracker.findById(answer);
        if (item != null) {
            output.accept(String.format("Item: %s %s", item.getName(), item.getDecs()));
        } else {
            output.accept("Not found.");
        }
    }
}

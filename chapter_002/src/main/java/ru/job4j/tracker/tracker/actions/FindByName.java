package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.input.Input;
import ru.job4j.tracker.tracker.storage.Item;
import ru.job4j.tracker.tracker.storage.Tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите NAME: ");
        List<Item> item = tracker.findByName(answer);
        if (item.size() > 0) {
            for (int i = 0; i < item.size(); i++) {
                if (item.get(i) != null) {
                    System.out.println(String.format("Item: %s %s", item.get(i).getName(), item.get(i).getDecs()));
                }
            }
        } else {
            System.out.println("Not found.");
        }
    }
}

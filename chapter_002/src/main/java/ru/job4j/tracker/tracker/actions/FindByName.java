package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.storage.Item;
import ru.job4j.tracker.tracker.storage.Tracker;
import ru.job4j.tracker.tracker.input.Input;

public class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите NAME: ");
        Item[] item = tracker.findByName(answer);
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                if (item[i] != null) {
                    System.out.println(String.format("Item: %s %s", item[i].getName(), item[i].getDecs()));
                }
            }
        } else {
            System.out.println("Not found.");
        }
    }
}

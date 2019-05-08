package ru.job4j.tracker.tracker.actions;

import ru.job4j.tracker.tracker.storage.Item;
import ru.job4j.tracker.tracker.storage.Tracker;
import ru.job4j.tracker.tracker.input.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowItems extends BaseAction {
    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> items = tracker.getAll();
        System.out.println("All items: ");
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                System.out.println(String.format("%X) %s %s %s", (i + 1), items.get(i).getId(), items.get(i).getName(), items.get(i).getDecs()));
            }
        }
    }
}

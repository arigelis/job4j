package ru.job4j.tracker;

public class ShowItems extends BaseAction {
    protected ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.getAll();
        System.out.println("All items: ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(String.format("%X) %s %s %s", (i + 1), items[i].getId(), items[i].getName(), items[i].getDecs()));
            }
        }
    }
}

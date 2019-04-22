package ru.job4j.tracker;

public class FindById extends BaseAction{
    protected FindById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите ID: ");
        Item item = tracker.findById(answer);
        if (item != null) {
            System.out.println(String.format("Item: %s %s", item.getName(), item.getDecs()));
        } else {
            System.out.println("Not found.");
        }
    }
}

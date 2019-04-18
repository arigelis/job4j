package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public int key() {
        return 5;
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

    @Override
    public String info() {
        return "Find item by name.";
    }
}

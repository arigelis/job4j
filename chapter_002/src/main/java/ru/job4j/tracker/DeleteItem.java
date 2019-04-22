package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите ID пункта меню : ");
        boolean tmpResult = tracker.delete(answer);
        if (tmpResult) {
            System.out.println("Deleted.");
        } else {
            System.out.println("Not deleted.");
        }
    }

    @Override
    public String info() {
        return "Delete";
    }
}

package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    protected DeleteItem(int key, String name) {
        super(key, name);
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
}

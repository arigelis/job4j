package ru.job4j.tracker;

public class EditItem extends BaseAction {
    protected EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 0);
        String id = input.ask("Введите ID заменяемой заявки :");
        if (tracker.replace(id, item)) {
            System.out.println("Item was update");
        } else {
            System.out.println("Item not found");
        }
    }
}

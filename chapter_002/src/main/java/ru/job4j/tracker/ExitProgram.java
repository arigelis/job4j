package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
//        System.out.println("------------ Добавление новой заявки --------------");
//        String name = input.ask("Введите имя заявки :");
//        String desc = input.ask("Введите описание заявки :");
//        Item item = new Item(name, desc, 0);
//        String id = input.ask("Введите ID заменяемой заявки :");
//        if (tracker.replace(id, item)) {
//            System.out.println("Item was update");
//        } else {
//            System.out.println("Item not found");
//        }
    }

    @Override
    public String info() {
        return "Edit Item.";
    }
}

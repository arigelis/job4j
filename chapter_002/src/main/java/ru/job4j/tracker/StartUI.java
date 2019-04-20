package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для отображения заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявок.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска по ID.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа меню для поиска по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;


    public static boolean working = true;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            int currentSelect = ((ValidateInput) input).ask("select:", range);
            if (String.valueOf(currentSelect).equalsIgnoreCase(this.EXIT)) {
                working = false;
                System.out.println("Exit!!!");
                continue;
            }
            menu.select(currentSelect);
        } while (this.working);
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 0);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItem() {
        Item[] items = this.tracker.getAll();
        System.out.println("All items: ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(String.format("%X) %s %s %s", (i + 1), items[i].getId(), items[i].getName(), items[i].getDecs()));
            }
        }
    }

    private void editItem(String answer) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 0);
        String id = this.input.ask("Введите ID заменяемой заявки :");
        if (this.tracker.replace(id, item)) {
            System.out.println("Item was update");
        } else {
            System.out.println("Item not found");
        }
    }

    private void findByName(String answer) {
        answer = this.input.ask("Введите NAME: ");
        Item[] item = this.tracker.findByName(answer);
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

    private void findById(String answer) {
        answer = this.input.ask("Введите ID: ");
        Item item = this.tracker.findById(answer);
        if (item != null) {
            System.out.println(String.format("Item: %s %s", item.getName(), item.getDecs()));
        } else {
            System.out.println("Not found.");
        }
    }

    private void deleteItem(String answer) {
        answer = this.input.ask("Введите ID пункта меню : ");
        boolean tmpResult = this.tracker.delete(answer);
        if (tmpResult) {
            System.out.println("Deleted.");
        } else {
            System.out.println("Not deleted.");
        }
    }


    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0:Add");
        System.out.println("1:Show");
        System.out.println("2:Edit");
        System.out.println("3:Delete");
        System.out.println("4:Find by Id");
        System.out.println("5:Find by name");
        System.out.println("6:Exit");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
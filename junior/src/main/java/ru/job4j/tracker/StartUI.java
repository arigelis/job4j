package ru.job4j.tracker;

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
        boolean exit = false;
        boolean tmpResult = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                Item[] items = this.tracker.getAll();
                System.out.println("All items: ");
                items = this.tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println((i + 1) + ") " + items[i].getId() + " " + items[i].getName() + " " + items[i].getDecs());
                }
            } else if (EDIT.equals(answer)) {
                Item[] items = this.tracker.getAll();
                System.out.println("All items: ");
                items = this.tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println((i + 1) + ") " + items[i]);
                }
                answer = this.input.ask("Введите пункт меню : ");
                int index = Integer.parseInt(answer) - 1;
                if (items[index] != null) {
                    this.createItem();
                    items[index] = items[items.length - 1];
                    this.tracker.delete(items[items.length - 1].getId());
//                    items = Arrays.copyOf(items, items.length - 2);
                }
            } else if (DELETE.equals(answer)) {
//                Item[] items = this.tracker.getAll();
                System.out.println("All items: ");
                Item[] items = this.tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println((i + 1) + ") " + items[i].getId() + " " + items[i].getName() + " " + items[i].getDecs());
                }
                answer = this.input.ask("Введите пункт меню : ");
                int index = Integer.parseInt(answer) - 1;
                if (items[index] != null) {
                    tmpResult = this.tracker.delete(items[index].getId());
                    if (tmpResult) {
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Not deleted.");
                    }
                }
            } else if (FIND_BY_ID.equals(answer)) {
                answer = this.input.ask("Введите ID: ");
                Item item = this.tracker.findById(answer);
                if (item != null) {
                    System.out.println("Item: " + item.getName() + " " + item.getDecs());
                } else {
                    System.out.println("Not found.");
                }
            } else if (FIND_BY_NAME.equals(answer)) {
                answer = this.input.ask("Введите NAME: ");
                Item[] item = this.tracker.findByName(answer);
                if (item != null) {
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] != null)
                            System.out.println("Item: " + item[i].getName() + " " + item[i].getDecs());
                    }
                } else {
                    System.out.println("Not found.");
                }
            } else if (EXIT.equals(answer)) {
                System.out.println("Exit!!!");
                exit = true;
            }
        }
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
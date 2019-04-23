package ru.job4j.tracker.tracker.storage;

import ru.job4j.tracker.tracker.actions.*;
import ru.job4j.tracker.tracker.input.Input;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<BaseAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add"));
        this.actions.add(new ShowItems(1, "Show"));
        this.actions.add(new EditItem(2, "Edit"));
        this.actions.add(new DeleteItem(3, "Delete"));
        this.actions.add(new FindById(4, "Find by Id"));
        this.actions.add(new FindByName(5, "Find by name"));
        this.actions.add(new ExitProgram(6, "Exit"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        int counter = 0;
        System.out.println("Menu:");
        for (BaseAction action : this.actions) {
            if (action != null) {
                System.out.println(String.format("%x:%s", counter, action.info()));
                counter++;
            }
        }
    }
}
package ru.job4j.tracker.tracker.input;

import ru.job4j.tracker.tracker.storage.MenuOutException;

import java.util.ArrayList;
import java.util.List;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private ArrayList<String> answers = new ArrayList<>();
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    public StubInput(ArrayList<String> answers) {
        this.answers.addAll(answers);
    }

    @Override
    public String ask(String question) {
        return this.answers.get(this.position++);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean found = false;
        for (Integer integer : range) {
            if (integer == key) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new MenuOutException("Key not found.");
        }
        return key;
    }
}

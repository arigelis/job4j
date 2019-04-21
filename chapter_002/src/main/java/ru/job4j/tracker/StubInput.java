package ru.job4j.tracker;

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
    private String[] answers;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }

    @Override
    public int ask(String question, List range) {
        int tmp = -1;
        try {
            tmp = Integer.valueOf(this.answers[this.position]);
        } catch (MenuOutException moe) {
            System.out.println("Please select key from menu.");
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter validate data again.");
        }
        return tmp; //input.ask("select:", range)
    }
}

package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
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

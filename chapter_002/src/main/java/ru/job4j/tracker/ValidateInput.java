package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ValidateInput extends ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int ask(String question, List<Integer> range) {
        System.out.print(question);
        try {
            return Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return -1;
    }

}

package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Exit!!!");
//        System.exit(0);
        input = null;
    }

    @Override
    public String info() {
        return "Exit.";
    }
}

package ru.job4j.tracker.tracker.singletons;

public class TrackerSingleStaticFinalField implements SingletonImpl {
    private static final TrackerSingleStaticFinalField INSTANCE = new TrackerSingleStaticFinalField();

    private TrackerSingleStaticFinalField() {
    }

    public static TrackerSingleStaticFinalField getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinalField tracker = TrackerSingleStaticFinalField.getInstance();
    }
}
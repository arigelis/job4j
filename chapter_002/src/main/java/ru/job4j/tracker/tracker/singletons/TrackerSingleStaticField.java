package ru.job4j.tracker.tracker.singletons;


public class TrackerSingleStaticField implements SingletonImpl {
    private static TrackerSingleStaticField instance;

    private TrackerSingleStaticField() {
    }

    public static TrackerSingleStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticField();
        }
        return instance;
    }
}

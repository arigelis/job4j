package ru.job4j.tracker.tracker.singletons;

public class TrackerSingleStaticFinalFieldLazy implements SingletonImpl{
    private TrackerSingleStaticFinalFieldLazy() {
    }

    public static TrackerSingleStaticFinalFieldLazy getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleStaticFinalFieldLazy INSTANCE = new TrackerSingleStaticFinalFieldLazy();
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinalFieldLazy tracker = TrackerSingleStaticFinalFieldLazy.getInstance();
    }
}
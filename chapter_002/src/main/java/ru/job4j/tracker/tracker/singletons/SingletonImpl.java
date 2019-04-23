package ru.job4j.tracker.tracker.singletons;

import ru.job4j.tracker.tracker.storage.Item;

public interface SingletonImpl {

    // Конструкторы и методы.
    public default Item add(Item model) {
        return model;
    }
}

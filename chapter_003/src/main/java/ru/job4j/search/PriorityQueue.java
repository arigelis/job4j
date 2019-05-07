package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int counter = 0;
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (Task taskTmp : tasks) {
                if (taskTmp.getPriority() > task.getPriority()) {
                    tasks.add(counter, task);
                    break;
                } else if (taskTmp.getPriority() <= task.getPriority() && counter + 1 == tasks.size()) {
                    tasks.add(tasks.size(), task);
                    break;
                }
                counter++;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

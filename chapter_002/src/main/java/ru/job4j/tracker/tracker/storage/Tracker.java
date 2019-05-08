package ru.job4j.tracker.tracker.storage;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    public final ArrayList<Item> items = new ArrayList<>(10);

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position++, item);
        return item;
    }

    /**
     * @param id   id
     * @param item item
     * @return bool
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equalsIgnoreCase(id)) {
                items.add(i, item);
                items.get(i).setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    public ArrayList<Item> getAll() {
        return items;
    }

    /**
     * @param id id
     * @return bool
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (items.get(i).getId().equals(id)) {
                System.arraycopy(items.toArray(), i + 1, items.toArray(), i, position - i - 1);
                items.add(position--, null);
                result = true;
                break;
            }
//
        }
        return result;
    }

    /**
     * find all where null
     *
     * @return item[]
     */

    /**
     * @param key str
     * @return item[]
     */
    public Item[] findByName(String key) {
        int index = 0;
        Item[] addArray = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (items.get(i).getName().equals(key)) {
                addArray[index++] = items.get(i);
            }
        }
        return Arrays.copyOf(addArray, index);
    }

    /**
     * @param id id
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                result = items.get(i);
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return "" + System.currentTimeMillis() + Math.random();
    }
}
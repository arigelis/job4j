package ru.job4j.tracker;


/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

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
        this.items[this.position++] = item;
        return item;
    }

    /**
     * @param id   id
     * @param item item
     * @return bool
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equalsIgnoreCase(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @param id id
     * @return bool
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (result) {
                items[i - 1] = items[i];
                continue;
            }
            if (items[i].getId().equalsIgnoreCase(id)) {
                result = true;
            }
        }

        System.arraycopy(items, 0, items, 0, items.length - 1);
        return result;
    }

    /**
     * find all where null
     *
     * @return item[]
     */
    public Item[] findAll() {
        int nullQuantity = 0;
        for (int i = 0; i < items.length - nullQuantity; i++) {
            if (items[i] == null) {
                items[i] = items[items.length - 1 - nullQuantity];
                nullQuantity++;
            }
        }
        System.arraycopy(items, 0, items, 0, items.length - 1 - nullQuantity);
        return this.items;
    }

    /**
     * @param key str
     * @return item[]
     */
    public Item[] findByName(String key) {
        int confirmed = 0;
        Item addArray[] = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equalsIgnoreCase(key)) {
                addArray[confirmed] = items[i];
                confirmed++;
            }
        }
        System.arraycopy(addArray, 0, addArray, 0, confirmed);
        return addArray;
    }

    /**
     *
     * @param id id
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equalsIgnoreCase(id)) {
                result = items[i];
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
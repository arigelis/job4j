package ru.job4j.tracker;


import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    public final Item[] items = new Item[10];

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
            if (items[i] != null && items[i].getId().equalsIgnoreCase(id)) {
                items[i] = item;
                items[i].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] getAll() {
        return items;
    }

    /**
     * @param id id
     * @return bool
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i - 1);
                items[position--] = null;
                result = true;
                break;
            }
//            if (result) {
//                items[i - 1] = items[i];
//                continue;
//            }
//            if (items[i].getId().equalsIgnoreCase(id)) {
//                result = true;
//            }
        }

//        System.arraycopy(items, 0, items, 0, items.length - 1);
        return result;
    }

    /**
     * find all where null
     *
     * @return item[]
     */
    public Item[] findAll() {
//        position = 0;
//        Item[] itemNotNull = new Item[items.length];
//        for (int i = 0; i < items.length; i++) {
//            if (items[i] != null) {
//                itemNotNull[position] = items[i];
//                position++;
//            }
//        }
////        System.arraycopy(items, 0, items, 0, items.length - 1 - nullQuantity);
//        return Arrays.copyOf(itemNotNull, position);

        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * @param key str
     * @return item[]
     */
    public Item[] findByName(String key) {
        int index = 0;
        Item[] addArray = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                addArray[index++] = items[i];
            }
        }
        return Arrays.copyOf(addArray, index);
//        position = 0;
//        boolean found = false;
//        Item addArray[] = new Item[items.length];
//        for (int i = 0; i < items.length; i++) {
//            if (items[i] != null && items[i].getName().equalsIgnoreCase(key)) {
//                addArray[position] = items[i];
//                position++;
//                found = true;
//            }
//        }
//        if (found) {
//            return addArray;
//        } else {
//            return null;
//        }
    }

    /**
     * @param id id
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
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
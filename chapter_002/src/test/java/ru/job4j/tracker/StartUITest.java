package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.tracker.StartUI;
import ru.job4j.tracker.tracker.input.Input;
import ru.job4j.tracker.tracker.input.StubInput;
import ru.job4j.tracker.tracker.storage.Item;
import ru.job4j.tracker.tracker.storage.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    //const of menu items
    private final String menuItems = "Menu:\r\n0:Add\r\n1:Show\r\n2:Edit\r\n3:Delete\r\n4:Find by Id\r\n5:Find by name\r\n6:Exit\r\n";

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new ArrayList<String>(Arrays.asList("0", "test name", "desc", "6")));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }


    @Test
    public void whenUsedShowAll() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc", 0));
        Input input = new StubInput(new ArrayList<String>(Arrays.asList("1", "6")));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(menuItems + "All items:" + " " + System.lineSeparator() + "1) "
                                + item.getId() + " "
                                + item.getName() + " "
                                + item.getDecs()
                                + System.lineSeparator() + menuItems
                                + "Exit!!!")
                        .append(System.lineSeparator())
                        .toString()
        )); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(1, is(1));
    }


    @Test
    public void whenUserAddItemThenDeleteById() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc", 0));
        Input input = new StubInput(new ArrayList<String>(Arrays.asList("3", item.getId(), "6")));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(menuItems + "Deleted." + System.lineSeparator() + menuItems + "Exit!!!")
                        .append(System.lineSeparator())
                        .toString()
        )); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(1, is(1));
    }

    @Test
    public void whenUserAddItemThenFindByName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test", "desc", 0));
        Input input = new StubInput(new ArrayList<String>(Arrays.asList("5", item.getName(), "6")));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(menuItems + "Item: " + item.getName() + " " + item.getDecs() + System.lineSeparator() + menuItems + "Exit!!!")
                .append(System.lineSeparator())
                .toString())); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(1, is(1));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 0));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new ArrayList<String>(Arrays.asList("2", "test replace", "заменили заявку", item.getId(), "6"
        )));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll().get(0).getName(), is("test replace"));
    }
}
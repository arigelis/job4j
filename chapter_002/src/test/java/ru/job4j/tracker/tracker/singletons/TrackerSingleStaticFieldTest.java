package ru.job4j.tracker.tracker.singletons;

import org.junit.Test;
import ru.job4j.tracker.tracker.storage.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFieldTest {
    @Test
    public void whenTryToDuplicateInstance() {
        TrackerSingleStaticField trackerSingleStaticField1 = TrackerSingleStaticField.getInstance();
        trackerSingleStaticField1.add(new Item("test", "desc", 0));
        TrackerSingleStaticField trackerSingleStaticField2 = TrackerSingleStaticField.getInstance();
        assertThat(trackerSingleStaticField1,
                is(trackerSingleStaticField2));
    }

}
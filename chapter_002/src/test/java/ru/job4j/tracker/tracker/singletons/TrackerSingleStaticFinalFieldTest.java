package ru.job4j.tracker.tracker.singletons;

import org.junit.Test;
import ru.job4j.tracker.tracker.storage.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalFieldTest {
    @Test
    public void whenTryToDuplicateInstance() {
        TrackerSingleStaticFinalField trackerSingleStaticFinalField1 = TrackerSingleStaticFinalField.getInstance();
        trackerSingleStaticFinalField1.add(new Item("test", "desc", 0));
        TrackerSingleStaticFinalField trackerSingleStaticFinalField2 = TrackerSingleStaticFinalField.getInstance();
        assertThat(trackerSingleStaticFinalField1,
                is(trackerSingleStaticFinalField2));
    }

}
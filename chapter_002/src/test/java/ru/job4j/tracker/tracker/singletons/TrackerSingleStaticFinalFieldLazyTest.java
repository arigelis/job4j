package ru.job4j.tracker.tracker.singletons;

import org.junit.Test;
import ru.job4j.tracker.tracker.storage.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalFieldLazyTest {
    @Test
    public void whenTryToDuplicateInstance() {
        TrackerSingleStaticFinalFieldLazy trackerSingleStaticFinalField1 = TrackerSingleStaticFinalFieldLazy.getInstance();
        trackerSingleStaticFinalField1.add(new Item("test", "desc", 0));
        TrackerSingleStaticFinalFieldLazy trackerSingleStaticFinalField2 = TrackerSingleStaticFinalFieldLazy.getInstance();
        assertThat(trackerSingleStaticFinalField1,
                is(trackerSingleStaticFinalField2));
    }

}
package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class ProfilesTest {
    @Test
    public void profileToAddressTest() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = new ArrayList<>(
                Arrays.asList(
                        new Profile(new Address("Thomb", "Sfh", 22, 442)),
                        new Profile(new Address("Thomb", "Sfh", 22, 442)),
                        new Profile(new Address("Brk", "Str", 5, 12)),
                        new Profile(new Address("Brk", "Str", 5, 12)),
                        new Profile(new Address("Broadway", "Manssa", 2, 90))
                )
        );
        List<Address> result = new ArrayList<>();
        result.add(new Address("Brk", "Str", 5, 12));
        result.add(new Address("Broadway", "Manssa", 2, 90));
        result.add(new Address("Thomb", "Sfh", 22, 442));

        Assert.assertThat(profiles.collect(profileList).toString(), is(result.toString()));
    }
}
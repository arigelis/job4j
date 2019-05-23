package ru.job4j;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).distinct().sorted((p1, p2) -> p1.getCity().compareTo(p2.getCity())).collect(Collectors.toList());
    }
}

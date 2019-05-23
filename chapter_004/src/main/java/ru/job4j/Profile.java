package ru.job4j;

public class Profile {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Profile(Address address) {
        this.address = address;
    }

    public String getCity() {
        return this.address.getCity();
    }
}


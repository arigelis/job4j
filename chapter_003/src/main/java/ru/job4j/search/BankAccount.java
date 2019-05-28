package ru.job4j.search;

public class BankAccount {
    private double value;
    private String requisites;

    public double getValue() {
        return value;
    }

    public BankAccount() {
    }

    public BankAccount(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public void setValue(double value) {

        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

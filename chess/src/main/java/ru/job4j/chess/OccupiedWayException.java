package ru.job4j.chess;

public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super("Way is occupied!");
    }
}

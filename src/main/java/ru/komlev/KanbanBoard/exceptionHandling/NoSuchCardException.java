package ru.komlev.KanbanBoard.exceptionHandling;

public class NoSuchCardException extends RuntimeException {
    public NoSuchCardException(String message) {
        super(message);
    }
}

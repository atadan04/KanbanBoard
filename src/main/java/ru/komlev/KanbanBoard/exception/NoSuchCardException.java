package ru.komlev.KanbanBoard.exception;

public class NoSuchCardException extends RuntimeException {
    public NoSuchCardException(String message) {
        super(message);
    }
}

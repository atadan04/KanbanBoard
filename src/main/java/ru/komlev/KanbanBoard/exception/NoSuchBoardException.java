package ru.komlev.KanbanBoard.exception;

public class NoSuchBoardException extends RuntimeException {
    public NoSuchBoardException(String message) {
        super(message);
    }
}

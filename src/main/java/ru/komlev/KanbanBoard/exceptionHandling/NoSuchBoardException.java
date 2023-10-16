package ru.komlev.KanbanBoard.exceptionHandling;

public class NoSuchBoardException extends RuntimeException{
    public NoSuchBoardException(String message) {
        super(message);
    }
}

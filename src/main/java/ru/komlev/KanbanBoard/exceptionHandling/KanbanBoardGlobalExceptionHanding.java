package ru.komlev.KanbanBoard.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class KanbanBoardGlobalExceptionHanding {
    @ExceptionHandler
    public ResponseEntity<BoardIncorrectData> handleException(Exception ex) {
        BoardIncorrectData data = new BoardIncorrectData();
        data.setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}

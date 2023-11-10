package ru.komlev.KanbanBoard.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.komlev.KanbanBoard.dto.exception.BoardIncorrectDto;

@ControllerAdvice
public class KanbanBoardGlobalExceptionHanding {
    @ExceptionHandler
    public ResponseEntity<BoardIncorrectDto> handleException(Exception ex) {
        BoardIncorrectDto data = new BoardIncorrectDto();
        data.setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}

package ru.komlev.KanbanBoard.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class CardDto {
    private UUID id;
    private String description;
    private UUID statusId;
    private UUID boardId;
    private String responsible;         //ответственный
    private LocalDate dateOfStart;      //дата начала
    private LocalDate dateOfLastChange; //дата последнего изменения
    private LocalDate dateOfCompletion; // дата завершения
    private String priority;            // Приоритет
    private String type;

}

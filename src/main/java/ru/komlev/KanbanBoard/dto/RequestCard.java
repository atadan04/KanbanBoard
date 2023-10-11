package ru.komlev.KanbanBoard.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestCard {
    private UUID id;
    private String title;
    private UUID statusId;
    private UUID boardId;

}

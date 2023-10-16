package ru.komlev.KanbanBoard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RequestBoardDto {
    private UUID id;
    private UUID cardId;
    private UUID statusId;
    private UUID typeId;
    private UUID priorityId;


}

package ru.komlev.KanbanBoard.dto;

import lombok.Builder;
import lombok.Data;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.entity.Priority;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.entity.Type;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseBoardDto {
    private UUID id;
    private String name;
    private List<Status> pullStatuses;
    private List<Type> pullTypes;
    private List<Priority> pullPriority;
    private List<Card> pullCards;
}

package ru.komlev.KanbanBoard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.entity.Priority;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.entity.Type;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestBoardDto {
    private UUID id;
    @NotBlank
    private String name;
    private UUID cardId;
    private UUID statusId;
    private UUID typeId;
    private UUID priorityId;
}

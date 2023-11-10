package ru.komlev.KanbanBoard.dto;

import lombok.Builder;
import lombok.Data;
import ru.komlev.KanbanBoard.entity.Attachment;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CardDto {
    private UUID id;
    private String description;
    private UUID statusId;
    private UUID boardId;
    private String responsible;
    private LocalDate dateOfStart;
    private LocalDate dateOfLastChange;
    private LocalDate dateOfCompletion;
    private UUID priorityId;
    private UUID typeId;
    private List<Attachment> pullAttachments;
}

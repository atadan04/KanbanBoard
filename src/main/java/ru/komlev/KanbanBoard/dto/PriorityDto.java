package ru.komlev.KanbanBoard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PriorityDto {
    private UUID id;
    @NotBlank
    private String name;
    private UUID boardId;
}

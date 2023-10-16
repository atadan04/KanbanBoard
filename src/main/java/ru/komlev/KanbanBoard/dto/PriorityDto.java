package ru.komlev.KanbanBoard.dto;

import lombok.Builder;
import lombok.Data;
import ru.komlev.KanbanBoard.entity.Board;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PriorityDto {
    private UUID id;
    private String name;
    private List<Board> boards;
}

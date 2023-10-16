package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.PriorityDto;
import ru.komlev.KanbanBoard.entity.Priority;

@Component
@RequiredArgsConstructor
public class PriorityTransformer implements Transformer<PriorityDto, Priority, PriorityDto> {
    @Override
    public Priority transformTo(PriorityDto priorityDto) {
        return Priority.builder()
                .id(priorityDto.getId())
                .name(priorityDto.getName())
                .boards(priorityDto.getBoards())
                .build();
    }

    @Override
    public PriorityDto transformFrom(Priority priority) {
        return PriorityDto.builder()
                .id(priority.getId())
                .name(priority.getName())
                .boards(priority.getBoards())
                .build();
    }
}

package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.PriorityDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Priority;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.service.CardService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PriorityTransformer implements Transformer<PriorityDto, Priority, PriorityDto> {
    private final BoardService boardService;
    private final CardService cardService;

    @Override
    public Priority transformTo(PriorityDto priorityDto) {

        Board board = boardService.findById(priorityDto.getBoardId());
        List<Priority> priorityCurrentBoard = board.getPriorities();
        Priority priority =  Priority.builder()
                .id(priorityDto.getId())
                .name(priorityDto.getName())
                .boards(List.of(board))
                .build();
        priorityCurrentBoard.add(priority);
        board.setPriorities(priorityCurrentBoard);
        return priority;

    }

    @Override
    public PriorityDto transformFrom(Priority priority) {
        return PriorityDto.builder()
                .id(priority.getId())
                .name(priority.getName())
                .build();
    }
}

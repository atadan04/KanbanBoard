package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.StatusDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StatusTransformer implements Transformer<StatusDto, Status, StatusDto> {

    private final BoardService boardService;

    @Override
    public Status transformTo(StatusDto requestStatus) {
        Board board = boardService.findById(requestStatus.getBoardId());

        Status status = Status.builder()
                .id(requestStatus.getId())
                .name(requestStatus.getName())
                .boards(List.of(board)).build();
        board.setStatuses(List.of(status));
        return status;
    }

    @Override
    public StatusDto transformFrom(Status status) {
        return StatusDto.builder()
                .id(status.getId())
                .name(status.getName()).build();
    }
}

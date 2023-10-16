package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.RequestBoardDto;
import ru.komlev.KanbanBoard.dto.ResponseBoardDto;
import ru.komlev.KanbanBoard.entity.*;
import ru.komlev.KanbanBoard.service.CardService;
import ru.komlev.KanbanBoard.service.PriorityService;
import ru.komlev.KanbanBoard.service.StatusService;
import ru.komlev.KanbanBoard.service.TypeService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoardTransformer implements Transformer<RequestBoardDto, Board, ResponseBoardDto> {
    private final CardService cardService;
    private final StatusService statusService;
    private final TypeService typeService;
    private final PriorityService priorityService;

    @Override
    public Board transformTo(RequestBoardDto boardDto) {
        Card card = cardService.findById(boardDto.getCardId());
        Status status = statusService.findById(boardDto.getStatusId());
        Type type = typeService.findById(boardDto.getTypeId());
        Priority priority = priorityService.findById(boardDto.getPriorityId());

        return Board.builder()
                .id(boardDto.getId())
                .cards(List.of(card))
                .statuses(List.of(status))
                .types(List.of(type))
                .priorities(List.of(priority))
                .build();
    }

    @Override
    public ResponseBoardDto transformFrom(Board board) {
        return ResponseBoardDto
                .builder()
                .id(board.getId())
                .pullStatuses(board.getStatuses())
                .pullTypes(board.getTypes())
                .pullPriority(board.getPriorities())
                .build();

    }
}

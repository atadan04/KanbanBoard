package ru.komlev.KanbanBoard.transformer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.RequestBoardDto;
import ru.komlev.KanbanBoard.dto.ResponseBoardDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.service.*;

@Component
@Data
@RequiredArgsConstructor
public class BoardTransformer implements Transformer<RequestBoardDto, Board, ResponseBoardDto> {
    private final CardService cardService;
    private final StatusService statusService;
    private final TypeService typeService;
    private final PriorityService priorityService;
    private final BoardService boardService;

    @Override
    public Board transformTo(RequestBoardDto boardDto) {
        return Board.builder()
                .id(boardDto.getId())
                .name(boardDto.getName())
                .build();
    }

    @Override
    public ResponseBoardDto transformFrom(Board board) {
        return ResponseBoardDto
                .builder()
                .id(board.getId())
                .name(board.getName())
                .pullStatuses(board.getStatuses())
                .pullTypes(board.getTypes())
                .pullPriority(board.getPriorities())
                .pullCards(board.getCards())
                .build();

    }
}

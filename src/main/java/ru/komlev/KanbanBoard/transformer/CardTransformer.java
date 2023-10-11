package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.RequestCard;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.service.StatusService;

@Component
@RequiredArgsConstructor
public class CardTransformer implements Transformer<RequestCard, Card> {

    private final StatusService statusService;
    private final BoardService boardService;

    @Override
    public Card transformTo(RequestCard requestCard) {
        Status status = statusService.findById(requestCard.getStatusId());
        Board board = boardService.findById(requestCard.getBoardId());
        return Card.builder()
                .id(requestCard.getId())
                .taskTitle(requestCard.getTitle())
                .status(status)
//                .board(board)
                .build();
    }

    @Override
    public RequestCard transformFrom(Card card) {
        throw new RuntimeException("non implemented");
    }
}

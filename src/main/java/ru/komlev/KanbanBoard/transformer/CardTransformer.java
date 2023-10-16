package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.CardDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.service.StatusService;

@Component
@RequiredArgsConstructor
public class CardTransformer implements Transformer<CardDto, Card, CardDto> {

    private final StatusService statusService;
    private final BoardService boardService;

    @Override
    public Card transformTo(CardDto requestCard) {
        Status status = statusService.findById(requestCard.getStatusId());
        Board board = boardService.findById(requestCard.getBoardId());
        return Card.builder()
                .id(requestCard.getId())
                .description(requestCard.getDescription())
                .status(status)
                .board(board)
                .build();
    }

    @Override
    public CardDto transformFrom(Card card) {
        return CardDto.builder()
                .id(card.getId())
                .description(card.getDescription())
                .statusId(card.getStatus().getId())
                .boardId(card.getBoard().getId())
                .responsible(card.getResponsible())
                .dateOfStart(card.getDateOfStart())
                .dateOfLastChange(card.getDateOfLastChange())
                .dateOfCompletion(card.getDateOfCompletion())
                .priority(card.getPriority())
                .type(card.getType())
                .build();

    }
}

package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.CardDto;
import ru.komlev.KanbanBoard.entity.*;
import ru.komlev.KanbanBoard.service.*;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CardTransformer implements Transformer<CardDto, Card, CardDto> {

    private final StatusService statusService;
    private final BoardService boardService;
    private final TypeService typeService;
    private final PriorityService priorityService;
    private final AttachmentService attachmentService;

    @Override
    public Card transformTo(CardDto requestCard) {
        Status status = statusService.findById(requestCard.getStatusId());
        Board board = boardService.findById(requestCard.getBoardId());
        Type type = typeService.findById(requestCard.getTypeId());
        Priority priority =priorityService.findById(requestCard.getPriorityId());
//        Attachment attachment = attachmentService.findById(requestCard.getAttachmentId());

        Card responseCard = Card.builder()
                .id(requestCard.getId())
                .description(requestCard.getDescription())
                .status(status)
                .board(board)
                .type(type)
                .priority(priority)
                .attachments(requestCard.getPullAttachments())
                .build();
        return responseCard;
    }

    @Override
    public CardDto transformFrom(Card card) {
        return CardDto.builder()
                .id(card.getId())
                .description(card.getDescription())
                .statusId(card.getStatus()!=null?card.getStatus().getId():null)
                .boardId(card.getBoard().getId())
                .responsible(card.getResponsible())
                .dateOfStart(card.getDateOfStart())
                .dateOfLastChange(card.getDateOfLastChange())
                .dateOfCompletion(card.getDateOfCompletion())
                .priorityId(card.getPriority()!=null?card.getPriority().getId():null)
                .typeId(card.getType()!=null?card.getType().getId():null)
                .pullAttachments(card.getAttachments()!=null?card.getAttachments():null)
                .build();

    }
}

package ru.komlev.KanbanBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.dto.RequestCard;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.service.CardService;
import ru.komlev.KanbanBoard.service.StatusService;
import ru.komlev.KanbanBoard.transformer.Transformer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final StatusService statusService;
    private final Transformer<RequestCard, Card> cardTransformer;

    @GetMapping("/")
    public ResponseEntity<List<Card>> getAll() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Card> insert(@RequestBody RequestCard requestCard) {
        Card card = cardTransformer.transformTo(requestCard);
        return ResponseEntity.ok(cardService.add(card));
    }

    @DeleteMapping("/")
    public void deleteById(UUID id) {
        cardService.deleteById(id);
    }

}

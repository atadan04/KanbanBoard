package ru.komlev.KanbanBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.dto.CardDto;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.exceptionHandling.NoSuchCardException;
import ru.komlev.KanbanBoard.service.CardService;
import ru.komlev.KanbanBoard.transformer.CardTransformer;
import ru.komlev.KanbanBoard.transformer.Transformer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final Transformer<CardDto, Card, CardDto> cardTransformer;


    @GetMapping("/")
    public ResponseEntity<List<CardDto>> getAll() {
        List<Card> cardList = cardService.findAll();
        List<CardDto> cardDtoList = cardList.stream().map(card->cardTransformer.transformFrom(card)).toList();
        return ResponseEntity.ok(cardDtoList);
    }

    @GetMapping("/{id}")

    public ResponseEntity<CardDto> getById(@PathVariable UUID id) {
        if (cardService.findById(id) != null) {
             Card card = cardService.findById(id);
            return ResponseEntity.ok(cardTransformer.transformFrom(card));
        }
        throw new NoSuchCardException(String.format("Card by id %s not found in database", id));
    }

    @PostMapping("/")
    public ResponseEntity<CardDto> insert(@RequestBody CardDto requestCard) {
        Card card = cardTransformer.transformTo(requestCard);
        cardService.add(card);
        return ResponseEntity.ok(cardTransformer.transformFrom(card));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        cardService.deleteById(id);
    }

}

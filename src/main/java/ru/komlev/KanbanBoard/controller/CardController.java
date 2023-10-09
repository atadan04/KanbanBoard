package ru.komlev.KanbanBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.service.CardService;
import ru.komlev.KanbanBoard.service.StatusService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class CardController {
    CardService cardService;
    StatusService statusService;
@Autowired
    public CardController(CardService cardService, StatusService statusService) {
        this.cardService = cardService;
        this.statusService = statusService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Card>> getAll(){
        return ResponseEntity.ok(cardService.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<Card> insert(@RequestBody Card card){
        return ResponseEntity.ok(cardService.add(card));
    }
    @DeleteMapping("/")
    public void deleteById(UUID id){
        cardService.deleteById(id);
    }

}

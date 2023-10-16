package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.repository.CardRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    public Card add(Card card) {
        return repository.save(card);

    }

    public List<Card> findAll() {
        return repository.findAll();
    }

    public Card findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

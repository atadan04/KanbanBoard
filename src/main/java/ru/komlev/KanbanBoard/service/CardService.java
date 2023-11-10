package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Attachment;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.repository.CardRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    public Card save(Card card) {
        return repository.save(card);

    }

    public List<Card> findAll() {
        return repository.findAll();
    }

    public Card findById(UUID id) {
        return id != null ? repository.findById(id).orElse(null) : null;

    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public List<Card> findByAttachments(Attachment attachment) {
        return repository.findByAttachments(attachment);
    }
}

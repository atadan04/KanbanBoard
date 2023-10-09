package ru.komlev.KanbanBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.repository.CardRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private CardRepository repository;
    @Autowired
    public CardService(CardRepository repository) {
        this.repository = repository;
    }
    public Card add(Card card){
        return repository.save(card);

    }
    public List<Card> findAll(){
       return repository.findAll();
    }
    public void deleteById(UUID id){
         repository.deleteById(id);
    }
}

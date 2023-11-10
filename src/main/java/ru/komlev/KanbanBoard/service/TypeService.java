package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Type;
import ru.komlev.KanbanBoard.repository.TypeRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final TypeRepository repository;

    public Type add(Type type) {
        return repository.save(type);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Type findById(UUID id) {
        return id != null ? repository.findById(id).orElse(null) : null;
    }

    public List<Type> findByBoard(Board board) {
        return repository.findByBoards(board);
    }
}

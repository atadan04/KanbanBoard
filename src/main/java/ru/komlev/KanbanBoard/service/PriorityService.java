package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Priority;
import ru.komlev.KanbanBoard.repository.PriorityRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PriorityService {
    private final PriorityRepository repository;

    public Priority add(Priority priority) {
        return repository.save(priority);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Priority findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public List<Priority> findByBoard(Board board) {
        return repository.findByBoards(board);
    }
}

package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.repository.StatusRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository repository;


    public Status add(Status status) {

        return repository.save(status);

    }

    public List<Status> findAll() {
        return repository.findAll();
    }

    public Status findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public List<Status> findByBoard(Board board) {
        return repository.findByBoards(board);
    }
}

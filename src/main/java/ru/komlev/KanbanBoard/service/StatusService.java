package ru.komlev.KanbanBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.repository.StatusRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StatusService {
    private StatusRepository repository;

    @Autowired
    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

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

}

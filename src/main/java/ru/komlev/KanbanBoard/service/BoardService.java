package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.repository.BoardRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board findById(UUID id) {
        return boardRepository.findById(id).orElse(null);
    }

}

package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.repository.BoardRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board findById(UUID id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board insert(Board board) {
        return boardRepository.save(board);
    }

    public void deleteById(UUID id) {
        boardRepository.deleteById(id);
    }
}

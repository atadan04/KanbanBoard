package ru.komlev.KanbanBoard.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.dto.RequestBoardDto;
import ru.komlev.KanbanBoard.dto.ResponseBoardDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.exception.NoSuchBoardException;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.transformer.BoardTransformer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardTransformer boardTransformer;

    @GetMapping("/")
    public ResponseEntity<List<ResponseBoardDto>> getAll() {
        List<Board> boardList = boardService.findAll();
        return ResponseEntity.ok(boardList.stream()
                .map(board -> boardTransformer.transformFrom(board))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBoardDto> getById(@PathVariable UUID id) {
        if (boardService.findById(id) != null) {
            Board board = boardService.findById(id);
            return ResponseEntity.ok(boardTransformer.transformFrom(board));
        }
        throw new NoSuchBoardException(String.format("Board by id %s not found in database", id));

    }

    @PostMapping("/")
    public ResponseEntity<ResponseBoardDto> add(@Valid @RequestBody RequestBoardDto requestBoardDto) {
        Board board = boardService.insert(boardTransformer.transformTo(requestBoardDto));
        return ResponseEntity.ok(boardTransformer.transformFrom(board));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        boardService.deleteById(id);
    }
}

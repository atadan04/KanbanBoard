package ru.komlev.KanbanBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.dto.TypeDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Type;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.service.TypeService;
import ru.komlev.KanbanBoard.transformer.TypeTransformer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/type")
@RequiredArgsConstructor
public class TypeController {
    private final BoardService boardService;
    private final TypeService typeService;
    private final TypeTransformer typeTransformer;

    @GetMapping("/{boardId}")
    public ResponseEntity<List<TypeDto>> findByBoard(@PathVariable UUID boardId) {
        Board board = boardService.findById(boardId);
        List<TypeDto> typeDtos = typeService.findByBoard(board).stream()
                .map(type -> typeTransformer.transformFrom(type))
                .toList();
        return ResponseEntity.ok(typeDtos);
    }

    @PostMapping("/")
    public ResponseEntity<TypeDto> add(TypeDto typeDto) {
        Type type = typeService.add(typeTransformer.transformTo(typeDto));
        return ResponseEntity.ok(typeTransformer.transformFrom(type));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        typeService.deleteById(id);
    }


}

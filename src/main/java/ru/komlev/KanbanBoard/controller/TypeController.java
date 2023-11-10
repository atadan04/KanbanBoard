package ru.komlev.KanbanBoard.controller;

import jakarta.validation.Valid;
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
                .peek(elem -> elem.setBoardId(board.getId()))
                .toList();
        return ResponseEntity.ok(typeDtos);
    }

    @PostMapping("/")
    public ResponseEntity<TypeDto> add(@Valid @RequestBody TypeDto requestTypeDto) {
        Type type = typeService.add(typeTransformer.transformTo(requestTypeDto));
        TypeDto responseTypeDto = typeTransformer.transformFrom(type);
        responseTypeDto.setBoardId(requestTypeDto.getBoardId());
        return ResponseEntity.ok(responseTypeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        typeService.deleteById(id);
    }


}

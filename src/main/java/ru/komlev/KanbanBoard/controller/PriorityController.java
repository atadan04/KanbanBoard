package ru.komlev.KanbanBoard.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.dto.PriorityDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Priority;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.service.PriorityService;
import ru.komlev.KanbanBoard.transformer.PriorityTransformer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/priority")
@RequiredArgsConstructor
public class PriorityController {
    private final BoardService boardService;
    private final PriorityService priorityService;
    private final PriorityTransformer priorityTransformer;

    @GetMapping("/{boardId}")
    public ResponseEntity<List<PriorityDto>> findByBoard(@PathVariable UUID boardId) {
        Board board = boardService.findById(boardId);
        List<PriorityDto> priorityDtos = priorityService.findByBoard(board).stream()
                .map(priority -> priorityTransformer.transformFrom(priority))
                .toList();
        return ResponseEntity.ok(priorityDtos);
    }

    @PostMapping("/")
    public ResponseEntity<PriorityDto> add(@Valid @RequestBody PriorityDto requestPriorityDto) {
        Priority priority = priorityService.add(priorityTransformer.transformTo(requestPriorityDto));
        PriorityDto responsePriorityDto = priorityTransformer.transformFrom(priority);
        responsePriorityDto.setBoardId(requestPriorityDto.getBoardId());

        return ResponseEntity.ok(responsePriorityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        priorityService.deleteById(id);
    }
}

package ru.komlev.KanbanBoard.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.KanbanBoard.dto.StatusDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Status;
import ru.komlev.KanbanBoard.service.BoardService;
import ru.komlev.KanbanBoard.service.StatusService;
import ru.komlev.KanbanBoard.transformer.StatusTransformer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    private final StatusTransformer statusTransformer;
    private final BoardService boardService;

    @PostMapping("/")
    public ResponseEntity<StatusDto> add(@Valid @RequestBody StatusDto requestStatus) {
        Status status = statusTransformer.transformTo(requestStatus);
        status = statusService.add(status);
        StatusDto responseStatus = statusTransformer.transformFrom(status);
        responseStatus.setBoardId(requestStatus.getBoardId());
        return ResponseEntity.ok(responseStatus);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<List<StatusDto>> findByBoard(@PathVariable UUID boardId) {
        Board board = boardService.findById(boardId);
        List<StatusDto> list = statusService.findByBoard(board).stream()
                .map(statusTransformer::transformFrom)
                .peek(elem -> elem.setBoardId(board.getId()))
                .toList();
        return ResponseEntity.ok(list);
    }
}

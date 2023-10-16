package ru.komlev.KanbanBoard.dto;

import lombok.Builder;
import lombok.Data;
import ru.komlev.KanbanBoard.entity.Board;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserDto {
    private UUID id;
    private String login;
    private String password;
    private LocalDate birthday;
    private String email;
    private List<Board> boards;
}

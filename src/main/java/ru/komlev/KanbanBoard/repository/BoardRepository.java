package ru.komlev.KanbanBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komlev.KanbanBoard.entity.Board;

import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {
}

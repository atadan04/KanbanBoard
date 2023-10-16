package ru.komlev.KanbanBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Priority;

import java.util.List;
import java.util.UUID;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, UUID> {
    List<Priority> findByBoards(Board board);
}

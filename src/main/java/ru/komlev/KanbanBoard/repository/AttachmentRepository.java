package ru.komlev.KanbanBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komlev.KanbanBoard.entity.Attachment;
import ru.komlev.KanbanBoard.entity.Card;

import java.util.List;
import java.util.UUID;
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    List<Attachment> findByCards(Card card);
}

package ru.komlev.KanbanBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komlev.KanbanBoard.entity.Attachment;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.repository.AttachmentRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public Attachment findById(UUID id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    public Attachment save(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public void deleteById(UUID id) {
        attachmentRepository.deleteById(id);
    }

    public List<Attachment> findByCard(Card card){
        return attachmentRepository.findByCards(card);
    }
    public List<Attachment> findAll(){
        return attachmentRepository.findAll();
    }

}

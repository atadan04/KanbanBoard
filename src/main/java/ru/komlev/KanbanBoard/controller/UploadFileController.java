package ru.komlev.KanbanBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.komlev.KanbanBoard.api.cloudinary.CloudinaryManager;
import ru.komlev.KanbanBoard.entity.Attachment;
import ru.komlev.KanbanBoard.entity.Card;
import ru.komlev.KanbanBoard.service.AttachmentService;
import ru.komlev.KanbanBoard.service.CardService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class UploadFileController {
    private final CloudinaryManager cloudinaryManager;
    private final AttachmentService attachmentService;
    private final CardService cardService;

    @PostMapping("/{cardId}")
    public ResponseEntity<Attachment> upload(@RequestPart MultipartFile file,@PathVariable UUID cardId) throws IOException {
        Map<String, Object> response = cloudinaryManager.save(file);
        Card card = cardService.findById(cardId);
        if (response.containsKey("url")) {
            Attachment attachment = Attachment.builder()
                    .id(UUID.fromString(response.get("public_id").toString()))
                    .url(response.get("url").toString())
                    .name(file.getOriginalFilename())
                    .build();
            List<Card> cards = cardService.findByAttachments(attachment);
            cards.add(card);
            attachment.setCards(cards);
            attachment = attachmentService.save(attachment);
            List<Attachment> attachments = card.getAttachments();
            attachments.add(attachment);
            card.setAttachments(attachments);
            cardService.save(card);
            return ResponseEntity.ok(attachment);
        }
        throw new RuntimeException();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        attachmentService.deleteById(id);
        try {
            cloudinaryManager.delete(id.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{cardId}")
    public ResponseEntity<List<Attachment>> findByCard(@PathVariable UUID cardId){
        Card card = cardService.findById(cardId);
       List<Attachment> attachments = attachmentService.findByCard(card);
       return ResponseEntity.ok(attachments);
    }
    @GetMapping("/")
    public ResponseEntity<List<Attachment>> findAll(){
        List<Attachment> attachments = attachmentService.findAll();
        return ResponseEntity.ok(attachments);
    }
}

package ru.komlev.KanbanBoard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "attachment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    private UUID id;
    private String url;
    private String name;
    @ManyToMany(mappedBy = "attachments")
    private List<Card> cards;
}

package ru.komlev.KanbanBoard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "card", indexes = {
        @Index(name = "idx_card_title", columnList = "title")
})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private String responsible;
    @DateTimeFormat
    private LocalDate dateOfStart;
    @DateTimeFormat
    private LocalDate dateOfLastChange;
    @DateTimeFormat
    private LocalDate dateOfCompletion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private Type type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "board_id")
    private Board board;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "card_attachment",
            joinColumns = @JoinColumn(name = "attachment_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Attachment> attachments;
}

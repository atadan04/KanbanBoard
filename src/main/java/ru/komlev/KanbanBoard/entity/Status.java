package ru.komlev.KanbanBoard.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "status")

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String status;
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Card> cards;

}

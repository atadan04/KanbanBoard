package ru.komlev.KanbanBoard.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
@Data
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "task_title")
    private String taskTitle;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;


}

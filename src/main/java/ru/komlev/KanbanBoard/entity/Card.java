package ru.komlev.KanbanBoard.entity;

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
        @Index(name = "idx_card_title",columnList = "title")
})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;                //имя
    private String description;         //описание
    private String responsible;         //ответственный
    @DateTimeFormat
    private LocalDate dateOfStart;      //дата начала
    @DateTimeFormat
    private LocalDate dateOfLastChange; //дата последнего изменения
    @DateTimeFormat
    private LocalDate dateOfCompletion; // дата завершения
    private String priority;            // Приоритет
    private String type;                //Тип
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


}

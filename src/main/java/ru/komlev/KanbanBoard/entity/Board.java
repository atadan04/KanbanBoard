package ru.komlev.KanbanBoard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
//    @ManyToMany
//    @JoinTable(
//            name = "board_cards",
//            joinColumns = @JoinColumn(name = "cards_id"),
//            inverseJoinColumns = @JoinColumn(name = "board_id")
//    )
    @OneToMany(mappedBy = "board")
    private List<Card> cards;
    @ManyToMany
    @JoinTable(
            name = "board_status",
            joinColumns = @JoinColumn(name = "status_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id"))
    private List<Status> statuses;

    @ManyToMany()
    @JoinTable(
            name = "board_type",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")
    )
    private List<Type> types;

    @ManyToMany
    @JoinTable(
            name = "board_priority",
            joinColumns = @JoinColumn(name = "priority_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")

    )
    private List<Priority> priorities;


}

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
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "board_status",
            joinColumns = @JoinColumn(name = "status_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id"))
    private List<Status> statuses;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "board_type",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")
    )
    private List<Type> types;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "board_priority",
            joinColumns = @JoinColumn(name = "priority_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")

    )
    private List<Priority> priorities;


}

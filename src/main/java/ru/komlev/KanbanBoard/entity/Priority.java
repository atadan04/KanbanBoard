package ru.komlev.KanbanBoard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "priority")
@Builder
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "priorities", fetch = FetchType.LAZY)
    private List<Board> boards;


}

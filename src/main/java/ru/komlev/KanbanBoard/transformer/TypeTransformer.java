package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.TypeDto;
import ru.komlev.KanbanBoard.entity.Board;
import ru.komlev.KanbanBoard.entity.Type;
import ru.komlev.KanbanBoard.service.BoardService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TypeTransformer implements Transformer<TypeDto, Type, TypeDto> {
    private final BoardService boardService;
    @Override
    public Type transformTo(TypeDto typeDto) {
        Board board =  boardService.findById(typeDto.getBoardId());
       List<Type> typesCurrentBoard =  board.getTypes();

                 Type type = Type
                .builder()
                .id(typeDto.getId())
                .name(typeDto.getName())
                .boards(List.of(board))
                .build();
          typesCurrentBoard.add(type);
          board.setTypes(typesCurrentBoard);
          return type;
    }

    @Override
    public TypeDto transformFrom(Type type) {
        return TypeDto
                .builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }
}

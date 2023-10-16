package ru.komlev.KanbanBoard.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.komlev.KanbanBoard.dto.TypeDto;
import ru.komlev.KanbanBoard.entity.Type;

@Component
@RequiredArgsConstructor
public class TypeTransformer implements Transformer<TypeDto, Type, TypeDto> {
    @Override
    public Type transformTo(TypeDto typeDto) {
        return Type
                .builder()
                .id(typeDto.getId())
                .name(typeDto.getName())
                .boards(typeDto.getBoards())
                .build();
    }

    @Override
    public TypeDto transformFrom(Type type) {
        return TypeDto
                .builder()
                .id(type.getId())
                .name(type.getName())
                .boards(type.getBoards())
                .build();
    }
}

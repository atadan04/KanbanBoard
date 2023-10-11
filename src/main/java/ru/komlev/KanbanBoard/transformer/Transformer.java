package ru.komlev.KanbanBoard.transformer;

public interface Transformer<T, V> {
    V transformTo(T t);

    T transformFrom(V v);
}

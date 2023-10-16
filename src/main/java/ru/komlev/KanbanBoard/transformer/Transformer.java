package ru.komlev.KanbanBoard.transformer;

public interface Transformer<T, V, K> {
    V transformTo(T t);

    K transformFrom(V v);
}

package ru.tolkacheva.functional;

public interface BiConsumer<P, T>{
    void accept(P collection, T value);
}

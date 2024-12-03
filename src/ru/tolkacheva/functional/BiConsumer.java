package ru.tolkacheva.functional;

public interface BiConsumer<P, T>{
    P accept(P collection, T value);
}

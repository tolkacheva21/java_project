package ru.tolkacheva.sem3.functional;

public interface FilterRule<T> {
    boolean check(T value);
}

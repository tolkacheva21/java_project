package ru.tolkacheva.functional;

public interface FilterRule<T> {
    boolean check(T value);
}

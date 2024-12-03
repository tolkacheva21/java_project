package ru.tolkacheva.functional;

public interface Method <T, R>{
    R apply(T argument);
}

package ru.tolkacheva.spring.databases;

public class Employee {
    @Column("id") Integer id;
    String name;
    Integer depId;
}

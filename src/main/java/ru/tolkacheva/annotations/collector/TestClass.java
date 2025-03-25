package ru.tolkacheva.annotations.collector;

public class TestClass {
    @Invoke
    public String printHello() {
        return "Hello";
    }

    @Invoke
    public String printBye() {
        return "Bye";
    }

    public String printBlaBla() {
        return "Bla bla bla";
    }
}

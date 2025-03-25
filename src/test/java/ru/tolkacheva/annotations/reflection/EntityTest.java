package ru.tolkacheva.annotations.reflection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class EntityTest {
    class TestEntity extends Entity{
        private int privateField;
        public int publicField;
        int protectField;
    }

    @Test
    @DisplayName("Название класса присутствует в начале строки")
    public void nameClassTest() {
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.startsWith("TestEntity"),
                "expected " + res.getClass().getSimpleName() + " actual " + res);
    }

    @Test
    @DisplayName("Присутствует название и значение поля")
    public void fieldAndValueTest() {
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.contains("publicField=0"));
    }
}

package ru.tolkacheva.annotations.collector;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import ru.tolkacheva.annotations.validate.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MainCollectorTest extends TestCase{

    @Test
    public void testCollect() throws NoSuchMethodException
            , InvocationTargetException, InstantiationException, IllegalAccessException {

        Map<String, Object> result = MainCollector.collect(TestClass.class);

        assertEquals("Hello", result.get("printHello"));
        assertEquals("Bye", result.get("printBye"));

        assertEquals(2, result.size());
    }

    @Test
    public void testCollectWithNoMethods() throws NoSuchMethodException
            , InvocationTargetException, InstantiationException, IllegalAccessException {

        class EmptyClass {
            public EmptyClass() {};
        }

        Map<String, Object> result = MainCollector.collect(EmptyClass.class);

        assertTrue(result.isEmpty());
    }

//    @Test
//    public void testCollectWithMultipleInstances() throws NoSuchMethodException
//            , InvocationTargetException, InstantiationException, IllegalAccessException {
//
//        class InstanceClass {
//            private final int value;
//
//            public InstanceClass(int value) {
//                this.value = value;
//            }
//
//            @Invoke
//            public int getValue() {
//                return value;
//            }
//        }
//
//        Map<String, Object> result = MainCollector.collect(InstanceClass.class);
//
//        assertNotNull(result.get("getValue"));
//    }
}

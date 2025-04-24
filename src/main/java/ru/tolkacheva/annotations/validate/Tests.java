package ru.tolkacheva.annotations.validate;

import ru.tolkacheva.sem3.geometry.Point;
import ru.tolkacheva.annotations.reflection.ValidateException;

//@Validate(Test.class)
@AValidate
public class Tests {
    @Test
    void PolylineLengthTest(Point p) {
        if (p.x < 10) throw new ValidateException("x must be >=10");
    }
}

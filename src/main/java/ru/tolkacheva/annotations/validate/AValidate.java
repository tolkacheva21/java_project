package ru.tolkacheva.annotations.validate;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Validate({Tests.class})
public @interface AValidate {
}

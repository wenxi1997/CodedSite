package org.zwx.codedsite.core.annotation;


import java.lang.annotation.*;

@Repeatable(Attribute.Attributes.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {
    String value();
    String source() default "";
    Class<?> sourceClass() default Void.class;

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.METHOD})
    @interface Attributes {
        Attribute [] value();
    }
}

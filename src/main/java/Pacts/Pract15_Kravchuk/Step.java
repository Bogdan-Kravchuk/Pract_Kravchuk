package Pacts.Pract15_Kravchuk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



    @Retention(RetentionPolicy.RUNTIME) // Анотація має бути доступна під час виконання
    @Target(ElementType.METHOD)         // Застосовується тільки до методів
    public @interface Step {
        int order();
    }



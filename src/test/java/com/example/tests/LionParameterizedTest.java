package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String gender;

    public LionParameterizedTest(String gender) {
        this.gender = gender;
    }

    @Parameterized.Parameters
    public static Object[] invalidLionGender() {
        return new Object[] {
                null,
                "Неизвестно",
                "Unknown",
                "Лев",
                "Львица",
                "Lion",
                "Lioness",
        };
    }

     @Test
    public void constructorThrowsExceptionInvalidLionGender() {

        Feline feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion(gender, feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
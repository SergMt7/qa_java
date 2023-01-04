package com.example.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void getFamilyReturnFeline() {

        Feline feline = new Feline();
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }

    @Test
    public void getKittensReturnOne() {

        Feline feline = new Feline();
        int expectedResult = 1;
        int actualResult = feline.getKittens();
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }

    @Test
    public void getKittensReturnSome() {

        Feline feline = new Feline();
        int expectedResult = 3;
        int actualResult = feline.getKittens(3);
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }

    @Test
    public void getEatMeatReturnPredatorFood() throws Exception {

        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }
}

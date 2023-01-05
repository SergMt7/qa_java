package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodReturnPredatorFood() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = lion.getFood();
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }

    @Test
    public void getKittensReturnFelineKitten() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        int actualResult = lion.getKittens();
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }

    @Test
    public void getDoesHaveManeReturnHasMane() throws Exception {

        Lion lion = new Lion("Самец", feline);
        boolean expectedResult = true;
        boolean actualResult = lion.doesHaveMane();
        assertEquals("Некорректный результат", expectedResult, actualResult);
    }

    @Test
    public void constructorThrowsExceptionOnUnsupportedSex() {

        Feline feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> {
             Lion lion = new Lion("Неизвестно", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
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







































//@RunWith(Parameterized.class)
//public class LionParameterizedTest {
//    private final String lionMane;
//    private final boolean checkResult;
//
//    @Mock
//    private Feline feline;
//
//    @Before
//    public void init(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    public LionParameterizedTest(String lionMane, boolean checkResult) {
//        this.lionMane = lionMane;
//        this.checkResult = checkResult;
//    }
//
//    @Parameterized.Parameters
//    public static Object[][] setLionSex() {
//        return new Object[][]{
//                {"Самец", true},
//                {"Самка", false}
//        };
//    }
//
//    @Test
//    public void doesHaveManeCheck() throws Exception {
//        Lion lion = new Lion(lionMane, feline);
//        assertEquals(checkResult, lion.doesHaveMane());
//    }
//
//    @Test
//    public void getLionKittensReturnsValidNumber() throws Exception{
//        Lion lion = new Lion(lionMane, feline);
//        Mockito.when(feline.getKittens()).thenReturn(1);
//        int expectedResult = 1;
//        int actualResult = lion.getKittens();
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    public void getLionFoodReturnsPredatorMeal() throws Exception {
//        Lion lion = new Lion(lionMane, feline);
//        Mockito.when(feline.getFood("Травоядное")).thenReturn(List.of("Трава", "Различные растения"));
//        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
//        List <String> actualResult = lion.getFood();
//        List <String> expectedResult = List.of("Животные", "Птицы", "Рыба");
//        assertEquals(expectedResult, actualResult);
//    }
//}

package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalGetFoodTest {

    private final String eaterType;
    private final List<String> expectFoodList;
    private final String expectTextException;


    public AnimalGetFoodTest(String eaterType, List<String> expectFoodList, String expectTextException) {
        this.eaterType = eaterType;
        this.expectFoodList = expectFoodList;
        this.expectTextException = expectTextException;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getFoodResult() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), null},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},
                {"Птица", null, "Неизвестный вид животного, используйте значение Травоядное или Хищник"}
        };
    }

    @Test
    public void shouldBeGetFood() {
        try {
            Animal animal = new Animal();
            List<String> actualList = animal.getFood(eaterType);
            assertEquals(expectFoodList, actualList);
        } catch (Exception e) {
            assertEquals(expectTextException, e.getMessage());
        }
    }

}
package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void init() throws Exception {
        String sexLion = "Самец";
        lion = new Lion(feline, sexLion);
    }

    @Test
    public void getKittens() {
        int expectCountKitten = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectCountKitten);
        int actualCountKitten = lion.getKittens();
        assertEquals(expectCountKitten, actualCountKitten);
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectFoodList);
        List<String> actualFoodList = lion.getFood();
        assertEquals(expectFoodList, actualFoodList);
    }
}
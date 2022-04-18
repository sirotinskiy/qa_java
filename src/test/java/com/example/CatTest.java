package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    private Cat cat;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void shouldBeGetSound() {
        String expectSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectSound, actualSound);
    }

    @Test
    public void shouldBeGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectMeatList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeatList = cat.getFood();
        assertEquals(expectMeatList, actualMeatList);
    }
}
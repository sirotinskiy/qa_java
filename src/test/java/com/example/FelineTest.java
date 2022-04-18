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
public class FelineTest {

    @Mock
    private Animal animal;

    @Mock
    Feline felineMock;

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectListMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualListMeat = feline.eatMeat();
        assertEquals(expectListMeat, actualListMeat);
    }

    @Test
    public void shouldBeGetFamily() {
        String expectFamily = "Кошачьи";
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals(expectFamily, actualFamily);
    }

    @Test
    public void shouldBeGetKittensWithOutParam() {
        int expectKittenCount = 1;
        Mockito.when(felineMock.getKittens(expectKittenCount)).thenReturn(expectKittenCount);
        int actualKittenCount = feline.getKittens();
        assertEquals(expectKittenCount, actualKittenCount);
    }

    @Test
    public void shouldBeGetKittensWithParam() {
        int expectKittenCount = 1;
        int actualKittenCount = feline.getKittens(expectKittenCount);
        assertEquals(expectKittenCount, actualKittenCount);
    }
}
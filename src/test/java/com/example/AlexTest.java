package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    private Alex alex;

    @Mock
    private Feline feline;

    @Before
    public void init() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void shouldBeGetKittens() {
        int expectCountKitten = 0;
        int actualCountKitten = alex.getKittens();
        assertEquals(expectCountKitten, actualCountKitten);
    }

    @Test
    public void shouldBeGetFriends() {
        List<String> expectListFriends = List.of("Марти", "Глории", "Мелман");
        List<String> actualListFriends = alex.getFriends();
        assertEquals(expectListFriends, actualListFriends);
    }

    @Test
    public void shouldBeGetPlaceOfLiving() {
        String expectPlace = "Нью-Йоркский зоопарк";
        String actualPlace = alex.getPlaceOfLiving();
        assertEquals(expectPlace, actualPlace);
    }
}
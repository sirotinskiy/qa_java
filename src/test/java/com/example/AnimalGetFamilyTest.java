package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGetFamilyTest {

    @Test
    public void shouldBeGetFamily() {
        String expectedMessage = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Animal animal = new Animal();
        String actualMessage = animal.getFamily();
        assertEquals(expectedMessage,actualMessage);
    }
}
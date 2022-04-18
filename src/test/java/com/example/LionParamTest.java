package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Mock
    private static Feline feline;

    private final String sexLion;
    private final String expectMessageException;
    private final boolean expectMane;

    private Lion lion;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public LionParamTest(Feline feline, String sexLion, boolean expectMane, String expectMessageException) {
        this.feline = feline;
        this.sexLion = sexLion;
        this.expectMane = expectMane;
        this.expectMessageException = expectMessageException;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3}")
    public static Object[][] getFoodResult() {
        return new Object[][]{
                {feline, "Самец", true, null},
                {feline, "Самка", false, null},
                {feline, "smdfh", false, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void testConstructor() {
        try {
            lion = new Lion(feline, sexLion);
            assertTrue(lion instanceof Lion);
        } catch (Exception e) {
            assertEquals(expectMessageException, e.getMessage());
        }
    }

    @Test
    public void shouldBeDoesHaveMane() {
        try {
            lion = new Lion(feline, sexLion);
            boolean actualMane = lion.doesHaveMane();
            assertEquals(expectMane, actualMane);
        } catch (Exception e) {
            assertEquals(expectMessageException, e.getMessage());
        }
    }

}

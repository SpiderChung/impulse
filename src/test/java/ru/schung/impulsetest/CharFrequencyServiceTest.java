package ru.schung.impulsetest;


import org.junit.jupiter.api.Test;
import ru.schung.impulsetest.model.CharFrequency;
import ru.schung.impulsetest.service.CharFrequencyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharFrequencyServiceTest {
    @Test
    void testCalculateCharFrequency() {
        CharFrequencyService charFrequencyService = new CharFrequencyService();
        String input = "aaaaabcccc";

        List<CharFrequency> charFrequencies = charFrequencyService.calculate(input);

        assertEquals(3, charFrequencies.size());

        assertEquals('a', charFrequencies.get(2).getCharacter());
        assertEquals(5, charFrequencies.get(2).getQuantity());

        assertEquals('c', charFrequencies.get(1).getCharacter());
        assertEquals(4, charFrequencies.get(1).getQuantity());

        assertEquals('b', charFrequencies.get(0).getCharacter());
        assertEquals(1, charFrequencies.get(0).getQuantity());
    }
}

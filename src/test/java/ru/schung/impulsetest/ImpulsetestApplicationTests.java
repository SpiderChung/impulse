package ru.schung.impulsetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.schung.impulsetest.model.CharFrequency;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ImpulsetestApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void testSetCharacter() {
        char character = 'b';
        CharFrequency charFrequency = new CharFrequency('a', 4);
        charFrequency.setCharacter(character);
        assertThat(charFrequency.getCharacter()).isEqualTo(character);
    }



}

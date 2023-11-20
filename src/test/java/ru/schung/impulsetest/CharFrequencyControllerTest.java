package ru.schung.impulsetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.schung.impulsetest.controller.CharFrequencyController;
import ru.schung.impulsetest.model.CharFrequency;
import ru.schung.impulsetest.service.CharFrequencyService;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CharFrequencyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CharFrequencyService charFrequencyService;

    @InjectMocks
    private CharFrequencyController charFrequencyController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(charFrequencyController).build();
    }

    @Test
    void testGetCharFrequency() throws Exception {
        when(charFrequencyService.calculate(any(String.class)))
                .thenReturn(Collections.singletonList(new CharFrequency('a', 5)));

        mockMvc.perform(MockMvcRequestBuilders.post("/charFrequency")
                        .contentType("application/json")
                        .content("{\"input\": \"aaaaabcccc\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.frequencies[0].character").value("a"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.frequencies[0].quantity").value(5));

    }

    @Test
    void testGetCharFrequencyWithNullInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/charFrequency")
                        .contentType("application/json")
                        .content("{\"input\": null}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.frequencies").doesNotExist());
    }
}

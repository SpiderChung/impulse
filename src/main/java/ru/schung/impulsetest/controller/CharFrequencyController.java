package ru.schung.impulsetest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.schung.impulsetest.model.CharFrequency;
import ru.schung.impulsetest.model.InputRequest;
import ru.schung.impulsetest.service.CharFrequencyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CharFrequencyController {
    private final CharFrequencyService charFrequencyService;

    public CharFrequencyController(CharFrequencyService charFrequencyService) {
        this.charFrequencyService = charFrequencyService;
    }

    @PostMapping("/charFrequency")
    public Map<String, List<CharFrequency>> getCharFrequency(@RequestBody InputRequest inputRequest) {

        Map<String, List<CharFrequency>> responce = new HashMap<>();

        responce.put("frequencies", charFrequencyService.calculate(inputRequest.getInput()));
        return responce;
    }
}

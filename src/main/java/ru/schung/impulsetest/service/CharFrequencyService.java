package ru.schung.impulsetest.service;

import org.springframework.stereotype.Service;
import ru.schung.impulsetest.model.CharFrequency;

import java.util.*;

@Service
public class CharFrequencyService {
    public List<CharFrequency> calculate(String src) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : src.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        List<CharFrequency> charFrequencyList = new ArrayList<>();

        countMap.forEach((k, v) -> charFrequencyList.add(new CharFrequency(k, v)));

        charFrequencyList.sort(Comparator.comparingInt(CharFrequency::getQuantity));

        return charFrequencyList;
    }
}

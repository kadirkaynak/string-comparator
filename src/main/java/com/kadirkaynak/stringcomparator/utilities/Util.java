package com.kadirkaynak.stringcomparator.utilities;

import java.util.HashMap;
import java.util.Map;

public class Util {
    private Util(){}
    public static void repeatAppend(StringBuilder result, int repeatCount, Character ch) {
        for (int i = 0; i < repeatCount; i++) {
            result.append(ch);
        }
    }

    public static  Map<Character, Integer> frequencyCalculator(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLowerCase(ch)) map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}

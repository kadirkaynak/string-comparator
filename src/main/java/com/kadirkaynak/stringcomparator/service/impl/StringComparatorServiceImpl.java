package com.kadirkaynak.stringcomparator.service.impl;

import com.kadirkaynak.stringcomparator.dto.ComparatorDTO;
import com.kadirkaynak.stringcomparator.service.ComparatorService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.kadirkaynak.stringcomparator.utilities.Util.frequencyCalculator;
import static com.kadirkaynak.stringcomparator.utilities.Util.repeatAppend;
import static java.lang.Integer.signum;

@Service
public class StringComparatorServiceImpl implements ComparatorService {

    public String compare(ComparatorDTO comparatorDTO) {
        boolean[] checkArr = new boolean[26];
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> characterMap1 = frequencyCalculator(comparatorDTO.getS1());
        Map<Character, Integer> characterMap2 = frequencyCalculator(comparatorDTO.getS2());

        Map<Character, Integer> filteredCharacterMap1 = filterMap(characterMap1);
        Map<Character, Integer> filteredCharacterMap2 = filterMap(characterMap2);

        List<Map.Entry<Character, Integer>> entries1 = sortMap(filteredCharacterMap1);
        List<Map.Entry<Character, Integer>> entries2 = sortMap(filteredCharacterMap2);

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < entries1.size() && pointer2 < entries2.size()) {
            // check if the current Character is already added. If so, no need to make comparison
            if (checkArr[entries1.get(pointer1).getKey() - 'a']) {
                pointer1++;
                continue;
            }
            if (checkArr[entries2.get(pointer2).getKey() - 'a']) {
                pointer2++;
                continue;
            }

            // find prefix value according to the rules
            switch (findPrefix(entries1.get(pointer1), entries2.get(pointer2))) {
                case "1":
                    addValues(result, checkArr, "1", entries1.get(pointer1).getValue(), entries1.get(pointer1).getKey());
                    pointer1++;
                    break;
                case "2":
                    addValues(result, checkArr, "2", entries2.get(pointer2).getValue(), entries2.get(pointer2).getKey());
                    pointer2++;
                    break;
                case "=":
                    addValues(result, checkArr, "=", entries2.get(pointer2).getValue(), entries2.get(pointer2).getKey());
                    pointer1++;
                    pointer2++;
                    break;
                default:
            }
            if (pointer1 != entries1.size() || pointer2 != entries2.size()) result.append("/");
        }

        // at least one of the list ended, add the rest values of other list to the result if any
        addRestValues(result, entries1, pointer1, checkArr, "1");
        addRestValues(result, entries2, pointer2, checkArr, "2");

        return result.toString();
    }

    private String findPrefix(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
        int valueComparisonResult = entry1.getValue().compareTo(entry2.getValue());
        int keyComparisonResult = entry1.getKey().compareTo(entry2.getKey());
        return switch (signum(valueComparisonResult)) {
            case 1 -> "1"; // the frequency of first entity is higher than second entity
            case -1 -> "2"; // the frequency of second entity is higher than first entity
            default -> switch (signum(keyComparisonResult)) {
                case 1 -> "2"; // the alphabetical order of second entity is higher than first entity
                case -1 -> "1"; // the alphabetical order of first entity is higher than second entity
                default -> "="; // equal number of frequency and alphabetical order
            };
        };
    }


    private void addRestValues(StringBuilder result, List<Map.Entry<Character, Integer>> entries, int pointer, boolean[] checkArr, String prefix) {
        while (pointer < entries.size()) {
            if (checkArr[entries.get(pointer).getKey() - 'a']) {
                pointer++;
                continue;
            }
            addValues(result, checkArr, prefix, entries.get(pointer).getValue(), entries.get(pointer).getKey());
            pointer++;
            if (pointer != entries.size()) result.append("/");
        }
    }

    private void addValues(StringBuilder result, boolean[] checkArr, String prefix, int frequency, Character ch) {
        result.append(prefix);
        result.append(":");
        repeatAppend(result, frequency, ch);
        checkArr[ch - 'a'] = true;
    }

    private List<Map.Entry<Character, Integer>> sortMap(Map<Character, Integer> map) {
        // convert HashMap to a List of Map.Entry objects
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        // implement custom Comparator
        Comparator<Map.Entry<Character, Integer>> customComparator = Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed().thenComparing(Map.Entry::getKey);

        // sort the list using the custom Comparator
        Collections.sort(entryList, customComparator);
        return entryList;
    }

    private Map<Character, Integer> filterMap(Map<Character, Integer> map) {
        // filter map so that every item's frequency higher than 1
        return map.entrySet().stream().filter(a -> a.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}

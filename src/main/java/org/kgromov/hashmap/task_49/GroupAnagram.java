package org.kgromov.hashmap.task_49;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the together. You can return the answer in any order.
 */
public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        this::sortedCharsInString,
                        LinkedHashMap::new,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .toList();
    }

    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            if (groups.stream().anyMatch(g -> g.contains(word))) {
                continue;
            }
            var sortedString = sortedCharsInString(word);
            List<String> wordsInGroup = new ArrayList<>();
            wordsInGroup.add(word);
            groups.add(wordsInGroup);
            for (int j = i + 1; j < strs.length; j++) {
                String compareWith = strs[j];
                if (compareWith.length() == word.length()) {
                    var charsTpCompare = sortedCharsInString(compareWith);
                    if (charsTpCompare.equals(sortedString)) {
                        groups.getLast().add(compareWith);
                    }
                }
            }
        }
        return groups;
    }

    public List<List<String>> groupAnagramsSample(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> hsh = new HashMap<>();
        Set<String> sortedStrings = new LinkedHashSet<>();

        for (String str : strs) {
            String sorted = this.sortedCharsInString(str);
            hsh.computeIfAbsent(sorted, _ -> new ArrayList<>()).add(str);
            sortedStrings.add(sorted);
        }
        for (String str : sortedStrings) {
            groups.add(hsh.get(str));
        }
        return groups;
    }

    public List<List<String>> groupAnagramsCrazy(String[] strs) {
        return new java.util.AbstractList<>() {
            List<List<String>> result;
            Map<String, List<String>> map;

            private void init() {
                result = new ArrayList<>();
                map = new HashMap<>();
                for (String str : strs) {
                    char[] arr = new char[26];
                    for (char c : str.toCharArray()) {
                        arr[c - 'a']++;
                    }
                    String sortedStr = new String(arr);
                    map.computeIfAbsent(sortedStr, _ -> new ArrayList<>()).add(str);
                }
                result.addAll(map.values());
            }

            @Override
            public int size() {
                if (result == null) {
                    init();
                }
                return result.size();
            }

            @Override
            public List<String> get(int position) {
                return result.get(position);
            }
        };
    }

    private String sortedCharsInString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}

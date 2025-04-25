package org.kgromov.hashmap.task_290;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * <br>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * Specifically:
 * <br>
 * Each letter in pattern maps to exactly one unique word in s.
 * Each unique word in s maps to exactly one letter in pattern.
 * No two letters map to the same word, and no two words map to the same letter.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> charToStringHash = new HashMap<>();
        Map<String, Character> stringHashToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = words[i];
            if (!charToStringHash.computeIfAbsent(letter, _ -> word).equals(word)
                    || stringHashToChar.computeIfAbsent(word, _ -> letter) != letter) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
    }
}

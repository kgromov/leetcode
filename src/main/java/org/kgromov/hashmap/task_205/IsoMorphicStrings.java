package org.kgromov.hashmap.task_205;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <br>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <br>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class IsoMorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> directReplacements = new HashMap<>();
        Map<Character, Character> indirectReplacements = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char source = s.charAt(i);
            char replacement = t.charAt(i);
            if (directReplacements.computeIfAbsent(source, _ -> replacement) != replacement
                    || indirectReplacements.computeIfAbsent(replacement, _ -> source) != source) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic_optimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapS[c1] != mapT[c2]) {
                return false;
            }
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new IsoMorphicStrings();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic_optimal("badc", "baba"));
    }
}

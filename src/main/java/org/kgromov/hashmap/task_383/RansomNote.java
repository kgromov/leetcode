package org.kgromov.hashmap.task_383;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given two strings ransomNote and magazine, return true
 * if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <br>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        var magazineChars = magazine.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magazineChars.remove((Character) ransomNote.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // TODO: think about it - currently not working
    public boolean canConstructIndexOf(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] ransomNoteChars = ransomNote.toCharArray();
        Arrays.sort(ransomNoteChars);
        char[] magazineChars = magazine.toCharArray();
        Arrays.sort(magazineChars);
        String magazineSorted = String.valueOf(magazineChars);
        int i = 0;
        for (char c: ransomNoteChars) {
            if (magazineSorted.indexOf(c, i++) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstructCrazy(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) {
                return false;
            }
            alphabet[c % 26] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        System.out.println(solution.canConstruct("aab", "baa"));
        System.out.println(solution.canConstructIndexOf("aab", "baa"));
    }
}

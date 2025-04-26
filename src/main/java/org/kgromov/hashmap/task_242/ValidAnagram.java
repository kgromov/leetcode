package org.kgromov.hashmap.task_242;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an of s, and false otherwise.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }

    public boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCharsOccurrences = new int[26];
        int[] tCharsOccurrences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int sChar = s.charAt(i) % 26;
            sCharsOccurrences[sChar] = ++sCharsOccurrences[sChar];
            int tChar = t.charAt(i) % 26;
            tCharsOccurrences[tChar] = ++tCharsOccurrences[tChar];
        }
        return Arrays.equals(sCharsOccurrences, tCharsOccurrences);
    }

    public static void main(String[] args) {
        var solution = new ValidAnagram();
        System.out.println(solution.isAnagramOptimized("anagram", "nagaram"));
        System.out.println(solution.isAnagramOptimized("rat", "car"));
    }
}

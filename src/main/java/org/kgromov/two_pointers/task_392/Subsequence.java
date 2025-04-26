package org.kgromov.two_pointers.task_392;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <br>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class Subsequence {

    public boolean isSubsequence(String arg, String str) {
        if (arg.length() > str.length()) {
            return false;
        }
        int lastMatchedChar = -1;
        int matches = 0;
        for (int i = 0; i < arg.length(); i++) {
            char seekChar = arg.charAt(i);
            for (int j = lastMatchedChar + 1; j < str.length(); j++) {
                if (seekChar == str.charAt(j)) {
                    lastMatchedChar = j;
                    matches++;
                    break;
                }
            }
        }
        return matches == arg.length();
    }

    public boolean isSubsequence2(String arg, String str) {
        if (arg.length() > str.length()) {
            return false;
        }
        char[] s1 = arg.toCharArray();
        char[] s2 = str.toCharArray();
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
            }
            j++;
        }
        return i == s1.length;
    }

    public static void main(String[] args) {
        var solution = new Subsequence();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }
}

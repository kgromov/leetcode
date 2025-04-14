package org.kgromov.arrays.task_151;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an input string s, reverse the order of the words.
 * <br>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <br>
 * Return a string of the words in reverse order concatenated by a single space.
 * <br>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class WordsReverser {

    public String reverseWords(String s) {
        String[] words = s.strip().split("\\s+");
        if (words.length == 1) {
            return words[0];
        }
        int start = 0;
        int end = words.length - 1;
        while (start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        return String.join(" ", words);
    }

    public String reverseWords2(String s) {
        String[] words = s.strip().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new WordsReverser();
        System.out.println(solution.reverseWords("  hello world  "));
        System.out.println(solution.reverseWords("a good   example"));
    }
}

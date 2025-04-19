package org.kgromov.arrays.task_28;

/**
 * Given two strings needle and haystack,
 * return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class FirstIndexOfOccurrence {

    public int firstIndexOf(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        var solution = new FirstIndexOfOccurrence();
        System.out.println(solution.firstIndexOf("sadbutsad", "sad"));
        System.out.println(solution.firstIndexOf("leetcode", "leeto"));
    }
}

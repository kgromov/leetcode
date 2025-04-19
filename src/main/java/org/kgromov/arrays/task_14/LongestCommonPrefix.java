package org.kgromov.arrays.task_14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <br>
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length && !commonPrefix.isEmpty(); i++) {
            String prefix = commonPrefix.length() > strs[i].length()
                    ? commonPrefix.substring(0, strs[i].length())
                    : commonPrefix;
            commonPrefix = this.getCommonPrefix(prefix, strs[i]);
        }
        return commonPrefix;
    }

    private String getCommonPrefix(String prefix, String str) {
        int commonChars = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != str.charAt(i)) {
                break;
            }
            commonChars++;
        }
        return commonChars > 0 ? prefix.substring(0, commonChars) : "";
    }

    public static void main(String[] args) {
        var solution = new LongestCommonPrefix();
        String[] strings = {"flower", "flow", "flight"};
        String[] strings2 = {"dog", "racecar", "car"};
        String[] strings3 = {"cir", "car"};
        String[] strings4 = {"c", "acc", "ccc"};
        String[] strings5 = {"aac", "acab", "aa", "abba", "aa"};
        System.out.println(solution.longestCommonPrefix(strings));
        System.out.println(solution.longestCommonPrefix(strings2));
        System.out.println(solution.longestCommonPrefix(strings3));
        System.out.println(solution.longestCommonPrefix(strings4));
        System.out.println(solution.longestCommonPrefix(strings5));
    }
}

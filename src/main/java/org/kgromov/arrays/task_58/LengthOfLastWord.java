package org.kgromov.arrays.task_58;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <br>
 * A word is a maximal consisting of non-space characters only.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] words = s.strip().split("\\s+");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWord_optimal(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && result != 0) {
                break;
            } else if (s.charAt(i) != ' ') {
                result++;
            }
        }
        return result;
    }
}

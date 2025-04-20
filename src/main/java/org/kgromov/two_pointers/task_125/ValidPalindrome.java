package org.kgromov.two_pointers.task_125;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <br>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public boolean isPalindrome_(String s) {
        if (s.isBlank()) {
            return true;
        }
        char[] chars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s.isBlank()) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            if (!Character.isLetterOrDigit(startChar)) {
                start++;
                continue;
            }
            char endChar = s.charAt(end);
            if (!Character.isLetterOrDigit(endChar)) {
                end--;
                continue;
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new ValidPalindrome();
        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "race a car";
        String input3 = " ";
        String input4 = "ab_a";
        System.out.printf("'%s' is palindrome = %s%n", input1, solution.isPalindrome(input1));
        System.out.printf("'%s' is palindrome = %s%n", input2, solution.isPalindrome(input2));
        System.out.printf("'%s' is palindrome = %s%n", input3, solution.isPalindrome(input3));
        System.out.printf("'%s' is palindrome = %s", input4, solution.isPalindrome(input4));
    }
}

package org.kgromov.two_pointers.task_125;

public class ValidPalindromeNerdSolution {

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            int ch1 = val(s.charAt(start));
            if (ch1 < 0) {
                start++;
                continue;
            }
            int ch2 = val(s.charAt(end));
            if (ch2 < 0) {
                end--;
                continue;
            }
            if (ch1 != ch2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private int val(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return ch;
        if (ch >= 'A' && ch <= 'Z')
            return ch - 'A' + 'a';      //Upper to lower. If lower to upper then ch - 'a' + 'A';
        if (ch >= '0' && ch <= '9')
            return ch;
        return -1;
    }
}

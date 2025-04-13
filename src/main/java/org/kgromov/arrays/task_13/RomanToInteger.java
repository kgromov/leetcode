package org.kgromov.arrays.task_13;

import java.util.Map;

/**
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <br>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <br>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <br>
 * Given a roman numeral, convert it to an integer.
 */
// TODO: add human-readable solution with for and benchmarks
public class RomanToInteger {

    private final static Map<Character, Integer> ROMAN_VALUES = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt1(String romanDigit) {
        if (romanDigit == null || romanDigit.isBlank()) {
            throw new IllegalArgumentException("Invalid roman digit representation = " + romanDigit);
        }
        if (romanDigit.length() == 1) {
            return ROMAN_VALUES.get(romanDigit.charAt(0));
        }
        char[] romanNumbers = romanDigit.toCharArray();
        int decimalDigit = 0;
        int i = 0;
        while (i < romanNumbers.length) {
            char currentRomanChar = romanNumbers[i];
            if (i < romanNumbers.length - 1) {
                char nextRomanChar = romanNumbers[i + 1];
                switch (currentRomanChar) {
                    case 'I': {
                        if (nextRomanChar == 'V' || nextRomanChar == 'X') {
                            decimalDigit += ROMAN_VALUES.get(nextRomanChar) - ROMAN_VALUES.get(currentRomanChar);
                            i += 2;
                        } else {
                            decimalDigit += ROMAN_VALUES.get(currentRomanChar);
                            i++;
                        }
                        break;
                    }
                    case 'X': {
                        if (nextRomanChar == 'L' || nextRomanChar == 'C') {
                            decimalDigit += ROMAN_VALUES.get(nextRomanChar) - ROMAN_VALUES.get(currentRomanChar);
                            i += 2;
                        } else {
                            decimalDigit += ROMAN_VALUES.get(currentRomanChar);
                            i++;
                        }
                        break;
                    }
                    case 'C': {
                        if (nextRomanChar == 'D' || nextRomanChar == 'M') {
                            decimalDigit += ROMAN_VALUES.get(nextRomanChar) - ROMAN_VALUES.get(currentRomanChar);
                            i += 2;
                        } else {
                            decimalDigit += ROMAN_VALUES.get(currentRomanChar);
                            i++;
                        }
                        break;
                    }
                    default:
                        decimalDigit += ROMAN_VALUES.get(currentRomanChar);
                        i++;
                }
            } else {
                decimalDigit += ROMAN_VALUES.get(currentRomanChar);
                i++;
            }
        }
        return decimalDigit;
    }

    public int romanToInt(String romanDigit) {
        if (romanDigit == null || romanDigit.isBlank()) {
            throw new IllegalArgumentException("Invalid roman digit representation = " + romanDigit);
        }
        if (romanDigit.length() == 1) {
            return ROMAN_VALUES.get(romanDigit.charAt(0));
        }
        char[] romanNumbers = romanDigit.toCharArray();
        int decimalDigit = 0;
        int i = 0;
        while (i < romanNumbers.length) {
            int currentDecimalDigit = ROMAN_VALUES.get(romanNumbers[i]);
            if (i < romanNumbers.length - 1) {
                int nextDecimalDigit = ROMAN_VALUES.get(romanNumbers[i + 1]);
                int division = nextDecimalDigit / currentDecimalDigit;
                if ((currentDecimalDigit == 1 || currentDecimalDigit % 10 == 0) && (division == 5 || division == 10)) {
                    decimalDigit += (nextDecimalDigit - currentDecimalDigit);
                    i += 2;
                } else {
                    decimalDigit += currentDecimalDigit;
                    i++;
                }
            } else {
                decimalDigit += currentDecimalDigit;
                i++;
            }
        }
        return decimalDigit;
    }

    // absolutely mind-blowing - author should be hell of smart
    public int romanToInt_best(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var converter = new RomanToInteger();
        System.out.println(converter.romanToInt("III") + " = " + 3);
        System.out.println(converter.romanToInt("LVIII") + " = " + 58);
        System.out.println(converter.romanToInt_best("MCMXCIV") + " = " + 1994);
    }
}

package org.kgromov.arrays.task_12;

/**
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
 * Converting a decimal place value into a Roman numeral has the following rules:
 * <br>
 * If the value does not start with 4 or 9, select the symbol of the maximal value
 * that can be subtracted from the input, append that symbol to the result,
 * subtract its value, and convert the remainder to a Roman numeral.
 * If the value starts with 4 or 9 use the subtractive form representing one symbol
 * subtracted from the following symbol, for example,
 * 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
 * Only the following subtractive forms are used:
 * 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 * Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
 * You cannot append 5 (V), 50 (L), or 500 (D) multiple times.
 * If you need to append a symbol 4 times use the subtractive form.
 * <p>
 * Given an integer, convert it to a Roman numeral.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("1 is minimal number for conversion to Roman");
        }
        var roman = new StringBuilder();
        int length = (int) Math.log10(num);
        for (int i = length; i >= 0; i--) {
            int maxValue = (int) Math.pow(10, i);
            int division = num / maxValue;
            if (maxValue == 1000) {
                roman.append(this.romanByDecimalValue(maxValue).toString().repeat(division));
            } else if (division == 4 || division == 9) {
                roman.append(this.romanByDecimalValue(maxValue))
                        .append(this.romanByDecimalValue((division + 1) * maxValue));
            } else if (division >= 5) {
                roman.append(this.romanByDecimalValue(5 * maxValue));
                for (int j = 1; j <= division - 5; j++) {
                    roman.append(this.romanByDecimalValue(maxValue));
                }
            } else {
                roman.append(this.romanByDecimalValue(maxValue).toString().repeat(division));
            }
            num = num % maxValue;
        }
        return roman.toString();
    }

    private Character romanByDecimalValue(int value) {
        return switch (value) {
            case 1 -> 'I';
            case 5 -> 'V';
            case 10 -> 'X';
            case 50 -> 'L';
            case 100 -> 'C';
            case 500 -> 'D';
            case 1000 -> 'M';
            default -> throw new IllegalArgumentException("Not a roman decimal value");
        };
    }

    public static void main(String[] args) {
        var integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(3749) + " = MMMDCCXLIX");
        System.out.println(integerToRoman.intToRoman(1994) + " = MCMXCIV");
        System.out.println(integerToRoman.intToRoman(58) + " = LVIII");
        System.out.println(integerToRoman.intToRoman(6) + " = VI");
    }
}

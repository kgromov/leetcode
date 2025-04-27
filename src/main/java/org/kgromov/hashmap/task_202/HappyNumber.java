package org.kgromov.hashmap.task_202;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Write an algorithm to determine if a number n is happy.
 * <br>
 * A happy number is a number defined by the following process:
 * <br>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * <br>
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {

    public boolean isHappyRecursion(int n) {
        if (n == 1) {
            return true;
        }
       return this.isHappyRecursion(n, new HashSet<>());
    }

    public boolean isHappyRecursion(int number, Set<Integer> nums) {
        int sum = this.digitsSquareSum(number);
        nums.add(number);
        return sum == 1 || (!nums.contains(sum) && isHappyRecursion(sum, nums));
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int sum;
        Set<Integer> nums = new HashSet<>();
        while (n != 1 && !nums.contains(n)) {
            sum = this.digitsSquareSum(n);
            nums.add(n);
            n = sum;
        }
        return n == 1;
    }

    // no explanation - seems 4 is just a magic number
    public boolean isHappyOptimized(int n) {
        while (n != 1 && n != 4) {
            n = this.digitsSquareSum(n);
        }
        return n == 1;

    }

    private int digitsSquareSumStream(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .mapToInt(i -> (int) Math.pow(i, 2))
                .sum();
    }

    private int digitsSquareSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += (int) Math.pow(number % 10, 2);
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> result = String.valueOf(100).chars().map(Character::getNumericValue).boxed().toList();
        var solution = new HappyNumber();
        System.out.println("19 is happy = " + solution.isHappyRecursion(19));
        System.out.println("2 is happy = " + solution.isHappyRecursion(2));
    }
}

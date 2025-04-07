package org.kgromov.arrays.task_27;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementInArrayTest {
    private RemoveElementInArray solution;

    @BeforeEach
    void setUp() {
        solution = new RemoveElementInArray();
    }

    @Test
    void removeElement_1() {
        int[] nums = {3,2,2,3};
        int val = 3;

        int k = solution.removeElement(nums, val);

        assertEquals(2, k);
        assertArrayEquals(new int[]{2, 2}, nums);
    }

    @Test
    void removeElement_2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int k = solution.removeElement(nums, val);

        assertEquals(5, k);
        assertArrayEquals(new int[]{0,1,4,0,3}, nums);
    }
}
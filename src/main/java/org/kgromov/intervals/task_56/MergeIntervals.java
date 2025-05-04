package org.kgromov.intervals.task_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] startInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (startInterval[1] >= nextInterval[0] && startInterval[0] <= nextInterval[1]) {
                startInterval[1] = Math.max(startInterval[1], nextInterval[1]);
            } else {
                mergedIntervals.add(startInterval);
                startInterval = nextInterval;
            }
        }
        mergedIntervals.add(startInterval);
        return mergedIntervals.toArray(_ -> new int[0][0]);
    }

    public int[][] mergeOptimal(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(interval[0], max);
        }

        int[] mp = new int[max + 1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            mp[start] = Math.max(end + 1, mp[start]);
        }

        int r = 0;
        int have = -1;
        int intervalStart = -1;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) intervalStart = i;
                have = Math.max(mp[i] - 1, have);
            }
            if (have == i) {
                intervals[r++] = new int[] { intervalStart, have };
                have = -1;
                intervalStart = -1;
            }
        }

        if (intervalStart != -1) {
            intervals[r++] = new int[] { intervalStart, have };
        }
        if (intervals.length == r) {
            return intervals;
        }

        int[][] res = new int[r][];
        for (int i = 0; i < r; i++) {
            res[i] = intervals[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] intervals2 = {
                {1, 4},
                {4, 5}
        };
        int[][] intervals3 = {
                {1, 4},
                {0, 4}
        };
        int[][] intervals4 = {
                {1, 4},
                {0, 1}
        };
        int[][] intervals5 = {
                {1, 4},
                {0, 0}
        };
        int[][] intervals6 = {
                {1, 4},
                {0, 1}
        };
        int[][] intervals7 = {
                {2, 3},
                {4, 5},
                {1, 10}
        };
        var solution = new MergeIntervals();
        int[][] merged1 = solution.merge(intervals1);
        int[][] merged2 = solution.merge(intervals2);
        int[][] merged3 = solution.merge(intervals3);
        int[][] merged4 = solution.merge(intervals4);
        int[][] merged5 = solution.merge(intervals5);
        int[][] merged6 = solution.merge(intervals6);
        int[][] merged7 = solution.merge(intervals7);
    }
}

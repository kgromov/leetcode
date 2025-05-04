package org.kgromov.intervals.task_56;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <br>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <br>
 * Return intervals after the insertion.
 * <br>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> mergedIntervals = new ArrayList<>();
        int newIntervalIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (this.isOverlapped(currentInterval, newInterval)) {
                currentInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
                newIntervalIndex = i;
                break;
            } else {
                mergedIntervals.add(currentInterval);
                if (i < intervals.length - 1 && (currentInterval[1] < newInterval[0] && intervals[i + 1][0] > newInterval[1])) {
                    mergedIntervals.add(newInterval);
                    newIntervalIndex = i + 1;
                    break;
                }
            }
        }
        if (newIntervalIndex == -1) {
            if (intervals[0][0] > newInterval[1]) {
                mergedIntervals.addFirst(newInterval);
            } else {
                mergedIntervals.addLast(newInterval);
            }
        } else {
            int[] startInterval = intervals[newIntervalIndex];
            for (int i = newIntervalIndex + 1; i < intervals.length; i++) {
                int[] nextInterval = intervals[i];
                if (this.isOverlapped(startInterval, nextInterval)) {
                    startInterval[1] = Math.max(startInterval[1], nextInterval[1]);
                } else {
                    mergedIntervals.add(startInterval);
                    startInterval = nextInterval;
                }
            }
            mergedIntervals.add(startInterval);
        }
        return mergedIntervals.toArray(_ -> new int[0][0]);
    }

    private boolean isOverlapped(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0] && interval1[0] <= interval2[1];
    }

    public int[][] insertOptimal(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> result = new ArrayList<>();
        int newIntervalStart = newInterval[0], newIntervalEnd = newInterval[1];
        int n = intervals.length;
        int i = 0;
        while (i < n) {
            int[] currInterval = intervals[i];
            int currIntervalStart = currInterval[0], currIntervalEnd = currInterval[1];
            if (newIntervalStart > currIntervalEnd) {
                result.add(currInterval);
                i++;
            } else if (newIntervalEnd >= currIntervalStart) {
                newIntervalStart = Math.min(newIntervalStart, currIntervalStart);
                newIntervalEnd = Math.max(newIntervalEnd, currIntervalEnd);
                i++;
            } else {
                break;
            }
        }
        result.add(new int[]{newIntervalStart, newIntervalEnd});
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        int resultSize = result.size();
        int[][] resultTransformed = new int[resultSize][];
        for (int j = 0; j < resultSize; j++) {
            resultTransformed[j] = result.get(j);
        }
        return resultTransformed;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {1, 3},
                {6, 9}
        };
        int[][] intervals2 = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[][] intervals3 = {
                {1, 5},
        };
        int[][] intervals4 = {
                {3, 5},
                {12, 15}
        };
        var solution = new InsertInterval();
        int[][] merged4 = solution.insert(intervals4, new int[]{6, 6});
        int[][] merged1 = solution.insert(intervals1, new int[]{2, 5});
        int[][] merged2 = solution.insert(intervals2, new int[]{4, 8});
        int[][] merged3 = solution.insert(intervals3, new int[]{6, 8});
    }
}

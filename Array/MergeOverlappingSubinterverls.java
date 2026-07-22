import java.util.*;
public class MergeOverlappingSubinterverls {
public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 4}, {5, 7}, {6, 8}};
    int[][] mergedIntervals = merge(intervals);
    for (int[] interval : mergedIntervals) {
        System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }   
  }

    public static int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][];
            }
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int[][] merged = new int[intervals.length][2];
            int n = intervals.length;
            int mergedIndex = 0;
            for (int i = 0; i < n; i++) {
                if(mergedIndex == 0 || merged[mergedIndex - 1][1] < intervals[i][0]) {
                    merged[mergedIndex] = intervals[i];
                    mergedIndex++;
                } else {
                    merged[mergedIndex - 1][1] = Math.max(merged[mergedIndex - 1][1], intervals[i][1]);
                }
            }
            return Arrays.copyOf(merged, mergedIndex);
        }

}

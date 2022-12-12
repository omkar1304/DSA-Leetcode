// https://leetcode.com/problems/max-points-on-a-line/

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 2) return n;
        int max = 1;

        for (int i = 0; i < n; i++) {
            int[] a = points[i];
            Map<Double, Integer> map = new HashMap<>();
            int localMax = 1;

            for (int j = i + 1; j < n; j++) {

                double slope = getSlope(a, points[j]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            max = Math.max(max, localMax);
        }

        return max;
    }

    private double getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return Double.MAX_VALUE;
        if (a[1] == b[1]) return 0;
        return ((double) b[0] - a[0]) / ((double) b[1] - a[1]);
    }
}

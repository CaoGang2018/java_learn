package others.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author admin_cg
 * @data 2020/11/9 20:15
 */
public class Solution_973 {
    /*public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1]))));
        int[][] ans = new int[K][2];
        if (K >= 0) System.arraycopy(points, 0, ans, 0, K);
        return ans;
    }*/
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> temp =
                new PriorityQueue<>((o1, o2) -> (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]));
        for (int[] point : points) {
            temp.offer(point);
            if (temp.size() > K)
                temp.poll();
        }
        int[][] ans = new int[K][2];
        while (!temp.isEmpty()){
            ans[--K] = temp.poll();
        }
        return ans;
    }
}

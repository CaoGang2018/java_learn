package others.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/23 20:57
 */
public class Solution_56 {
    public static void main(String[] args) {
        Solution_56 ss = new Solution_56();
        //int[][] aa = {{1,3},{2,6},{8,10},{15,18}};
        int[][] aa = {{1,4},{2,3}};
        for(int[] t : ss.merge(aa)){
            System.out.println(Arrays.toString(t));
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals == null) return null;
        List<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        int i0 = 0;
        if(intervals.length == 0) return new int[0][0];
        while(intervals[i0] == null){
            i0++;
        }
        ans.add(intervals[i0]);
        for (int i = i0; i < intervals.length; i++) {
            if(intervals[i] == null) continue;
            int[] t = ans.get(ans.size()-1);
            if(t[1] >= intervals[i][0] && intervals[i][1] > t[1]){
                ans.remove(ans.size()-1);
                ans.add(new int[]{t[0], intervals[i][1]});
            }
            else if(t[1] < intervals[i][0]){
                ans.add(intervals[i]);
            }
        }
        int[][] an = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            an[i] = ans.get(i);
        }
        return an;
    }
}

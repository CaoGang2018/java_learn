package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/18 18:22
 */
public class Solution_11 {
    public int maxArea(int[] height) {
        int start = 0, end = height.length -1;
        int ans = 0;
        while(start < end){
            int area = Math.min(height[start], height[end]) * (end - start);
            ans = Math.max(ans, area);
            if(height[start] >= height[end])
                end--;
            else
                start++;
        }
        return  ans;
    }
}

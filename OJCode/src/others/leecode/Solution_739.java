package others.leecode;

/**
 * @author admin_cg
 * @date 2020/9/4 18:12
 */
public class Solution_739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        for (int i = n-2; i >= 0; i--) {
            int now = i+1;
            while(T[now] <= T[i]){
                if(ans[now] != 0)
                    now += ans[now];
                else {
                    break;
                }
            }
            if(T[now] > T[i])
                ans[i] = now - i;
            else ans[i] = 0;
        }
        return ans;
    }
}

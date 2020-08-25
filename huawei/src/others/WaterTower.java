package others;

/**
 * @author admin_cg
 * @date 2020/8/10 19:02
 */
public class WaterTower {
    public static void main(String[] args) {
        int[] a = {0, 1, 4, 6};
        int ans = 0;
        int sum = 6 / 2;
        for(int i = 0; i< a.length; i++){
            ans += Math.abs(a[i] - sum);
        }
        System.out.println(ans);
    }

}

package others;

import java.text.DecimalFormat;

/**
 * @author admin_cg
 * @date 2020/8/26 18:46
 */
public class sqrt_num {
    public static void main(String[] args) {
        System.out.print(mySqrt(8));
    }
    public static double mySqrt(int x) {
        int left = 0, right = x;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x){
                ans = mid;
                left = mid + 1;
            }
            else right = mid -1;
        }
        double l = (double)ans, r = (double)(ans+1);
        double a = 0.0;
        while(r-l >= 1e-11){
            double mid = l + (r - l) / 2;
            if (x - mid * mid >= 1e-11){
                a = mid;
                l = mid + 1e-11;
            }
            else r = mid -1e-11;
        }
        return a;
    }
}

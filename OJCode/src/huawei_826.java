import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

/**
 * @author admin_cg
 * @date 2020/8/26 19:38
 */
public class huawei_826 {
    public static void main(String[] args) {
        String[] strs = {"cloxy", "apqud", "cxmnu", "kcotd", "bldwz"};
        String s = and_(strs, 5);
        move(new long[]{1,2,3});
        int[] x = {1,1,1,1,2,1,1};
        int[] y = {5,2,5,4,5,1,6};
        Scanner sc = new Scanner(System.in);
        System.out.println(maxArea(x, y));
    }
    public static String and_(String[] str1, int k){
        int[] t = new int[26];
        for(String s : str1){
            for (int i = 0; i < s.length(); i++) {
                t[s.charAt(i) - 'a'] ++;
            }
        }
        //Arrays.sort(t);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(t[i]  > 1)
                sb.append((char)(i+'a'));
        }
        String resTemp = sb.toString();
        int[] x = {3,2,1,2,1};
        char[] ans = new char[k];
        for(String s : str1){
            for (int i = 0; i < s.length() && i < x[i]; i++) {
                if(resTemp.contains(s.substring(i, i+1)) && ans[i] == '\u0000')
                    ans[i] = s.charAt(i);
            }
        }
        System.out.println(Arrays.toString(ans));
        return "";
    }
    public static void move(long[] nums){
        for(int i = 0; i < nums.length; i++){
            long num = nums[i] ;
            long num2 = nums[i];
            nums[i] = ((num&0x55555555)<<1) ^ ((num2 &0xaaaaaaaa)>>1);
        }
        long t = nums[0]%4;
        for(int i = 1; i < nums.length; i++){
            long t2 = nums[i]%4;
            nums[i] = (t << 30) + (nums[i] >> 2);
            t = t2;
        }
        nums[0] = (nums[0] >> 2) + (t<<30);
        for(long num : nums){
            System.out.println(num);
        }
    }

    public static int maxArea(int[] x, int[] y){
        int maxAns = 0;
        for (int i = 0; i < x.length; i++) {
            int tmp = centerExtend(y, x, y[i], i);
            maxAns = Math.max(maxAns, tmp);
        }
        return maxAns;

    }
    private static int centerExtend(int[] y, int[] x, int anchor, int l){
        int left = l, right = l;
        while(left >=0 && y[left] >= anchor){
            left--;
        }
        while(right < y.length && y[right] >= anchor){
            ++right;
        }
        int ans = 0;
        ++left;
        while(left < right){
            ans += anchor * x[left];
            ++left;
        }
        return ans;
    }
}

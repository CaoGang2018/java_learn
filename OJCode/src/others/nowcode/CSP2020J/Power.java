package others.nowcode.CSP2020J;

import java.util.Scanner;

/**
 * @author admin_cg
 * @data 2020/11/9 19:38
 */
public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if ((n&1) == 1){
            System.out.println(-1);
        } else {
            int[] ans = new int[100];
            int count = 0;
            int v = 1;
            while (n != 0) {
                if ((n&1) == 1) {
                    ans[count++] = v;
                }
                v <<= 1;
                n >>= 1;
            }
            for (int i = count - 1; i >= 0; i--) {
                System.out.print(ans[i] + " ");
            }
        }
    }
}

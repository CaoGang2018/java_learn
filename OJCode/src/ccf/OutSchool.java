package ccf;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/9/15 16:06
 */
public class OutSchool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long red = sc.nextLong(), yellow = sc.nextLong(), green = sc.nextLong();
        long m = sc.nextLong();
        long ans = 0;
        for (long i = 0; i < m; i++) {
            int flag = sc.nextInt();
            long time = sc.nextLong();
            if(flag == 0)
                ans += time;
            else{
                if(flag == 1)
                    time = red + yellow - time;
                if(flag == 2)
                    time = yellow - time;
                if(flag == 3)
                    time = red + yellow + green - time;
                time += ans;

                time %= red + yellow + green;
                if(time > 0 && time < red + yellow)
                    ans += red + yellow - time;
            }
        }
        System.out.println(ans);
    }
}

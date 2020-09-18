package ccf;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/9/15 15:53
 */
public class GoToSchool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int red = sc.nextInt(), yellow = sc.nextInt(), green = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int syn = sc.nextInt();
            if(syn == 0 || syn == 1){
                ans += sc.nextInt();
            }
            else if(syn == 2){
                ans += red;
                ans += sc.nextInt();
            }
            else sc.nextInt();
        }
        System.out.println(ans);
    }
}

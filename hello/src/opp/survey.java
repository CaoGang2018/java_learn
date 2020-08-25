package opp;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/5 18:11
 */
public class survey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrs = new int[1001];
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                arrs[sc.nextInt()] ++;
            }
            print(arrs);
            Arrays.fill(arrs, 0);
        }

    }
    public static void print(int[] arrs){
        for(int i = 1; i < arrs.length; i++){
            if(arrs[i] != 0)
                System.out.println(i);
        }
    }
}

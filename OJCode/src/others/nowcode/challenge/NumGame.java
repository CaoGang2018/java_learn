package others.nowcode.challenge;

import java.util.Scanner;

/**
 * @author admin_cg
 * @data 2020/9/29 20:49
 */
public class NumGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][][] minF = new int[101][101][10];
        int[][][] maxF = new int[101][101][10];
        int[] nums = new int[101];
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i + n] = sc.nextInt();
        }
        for (int i = 2; i <= 2*n; i++){
            nums[i] += nums[i-1];
        }
        for (int i = 1; i <= 2 * n; i++) {
            for (int j = i+1; j <= 2*n; j++) {
                for (int k = 2; k <= j-i+1; k++) {
                    minF[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= 2 * n; i++) {
            for (int j = i; j <= 2*n; j++) {
                minF[i][j][1] = maxF[i][j][1] = mod(nums[j] - nums[i-1]);
            }
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= 2*n; j++) {
                for (int k = j+i-1; k <= 2*n; k++) {
                    for (int l = j+i-1-1; l < k-1; l++) {
                        minF[j][k][i] = Math.min(minF[j][k][i], minF[j][l][i-1]*mod(nums[k] - nums[l]));
                        maxF[j][k][i] = Math.max(maxF[j][k][i], maxF[j][l][i-1]*mod(nums[k] - nums[l]));
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, minF[i][i+n-1][m]);
            max = Math.max(max, maxF[i][i+n-1][m]);
        }
        System.out.println(min);
        System.out.println(max);
    }

    private static int mod(int i) {
        return ((i % 10) + 10) % 10;
    }
}

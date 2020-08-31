package others;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/29 16:16
 */
public class meituan829 {
    public static void main(String[] args) {
        //System.out.println(xuantiao());
        System.out.println(daoli());

    }
    public static List<String> xuantiao(){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> ans = new LinkedList<>();
        int n = sc.nextInt();
        sc.nextLine();
        if(n == 0) return ans;
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            for(String s : temp){
                if(!ans.contains(s)) {
                    ans.addLast(s);
                    break;
                }
            }
        }
        return ans;
    }

    public static int MaxValue = 100000;
    public static int daoli(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt()-1, y = sc.nextInt()-1;
        sc.nextLine();
        int[][] grid = new int[n][n];
        //初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < n-1; i++) {
            String[] in = sc.nextLine().split(" ");
            grid[Integer.parseInt(in[0])-1][Integer.parseInt(in[1])-1] = 1;
            grid[Integer.parseInt(in[1])-1][Integer.parseInt(in[0])-1] = 1;
        }
        dijstra(grid, x, y);
        dijstra(grid, y, x);
        int ans = shortest[y];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(shortest[i] > max && shortest[i] < MaxValue)
                max = shortest[i];
        }
        return ans + max;
    }
    public static int[] shortest;
    public static void dijstra(int[][] matrix, int source, int target) {
        //最短路径长度
        shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if(index == target){
                    matrix[source][m] = MaxValue+1;
                }
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                }
            }

        }
    }
}

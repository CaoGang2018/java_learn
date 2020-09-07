package others.nowcode;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/16 23:10
 */
public class ShortestRoad {
    public static final int maxValue = 6000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String[] str = st.substring(2, st.length() - 2).split("\\]\\,\\[");
        //System.out.println(str[1]);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.close();

        int[][] graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = maxValue;
            }
        }

        for (String s : str) {
            String[] tp = s.split(",");
            graph[Integer.parseInt(tp[0]) - 1][Integer.parseInt(tp[1]) - 1] = Integer.parseInt(tp[2]);
        }
        System.out.println(Dijkstra(graph, k-1));

    }
    public static int Dijkstra(int[][] graph, int source){

        int[] shortest = new int[graph.length];
        boolean[] flag = new boolean[graph.length];

        // 1 source 结点开始
        shortest[source] = 0;
        flag[source] = true;

        // 循环N-1次
        for(int i = 1; i < graph.length; i++){
            int max = Integer.MAX_VALUE;
            int idx = -1; // 用于记录最小结点
            // 寻找连接的最小节点
            for (int j = 0; j < graph.length; j++) {
                if(!flag[j] && graph[source][j] < max){
                    max= graph[source][j];
                    idx = j;
                }
            }

            // 更改shortest 大小
            shortest[idx] = max;
            flag[idx] = true;

            // 更新剩余结点距离
            for (int j = 0; j < graph.length; j++) {
                if(!flag[j] && graph[source][idx] + graph[idx][j] < graph[source][j]){
                    graph[source][j] = graph[source][idx] + graph[idx][j];
                }
            }
        }
        int ans = shortest[source];
        for (int i = 0; i < graph.length; i++) {
            if(shortest[i] > ans){
                ans = shortest[i];
            }
        }
        return ans;
    }
}

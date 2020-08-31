package others.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/28 19:55
 */
public class Solution_210 {
    private List<List<Integer>> edges;
    int[] visited;
    int[] ans;
    boolean valid = true;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] temp : prerequisites){
            edges.get(temp[1]).add(temp[0]);
        }
        visited = new int[numCourses];
        ans = new int[numCourses];
        index = numCourses;
        for (int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid ? ans : new int[0];

    }

    private void dfs(int u){
        visited[u] = 1;
        for(int v : edges.get(u)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid)
                    return;
            }
            else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        ans[--index] = u;
    }
}

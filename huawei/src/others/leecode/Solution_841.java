package others.leecode;

import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/31 17:49
 */
public class Solution_841 {
    boolean[] visited;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        visited = new boolean[n];
        backtrack(rooms, 0);
        return num == n;

    }

    public void backtrack(List<List<Integer>> rooms,int now){
        visited[now] = true;
        num++;
        for(int key : rooms.get(now)){
            if(!visited[key])
                backtrack(rooms, key);
        }
    }
}

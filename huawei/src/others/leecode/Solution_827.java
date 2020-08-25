package others.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author admin_cg
 * @date 2020/8/24 16:30
 */
public class Solution_827 {
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int index = 2;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    int tmp = dfs(grid, i, j, index);
                    map.put(index, tmp);
                    maxArea = Math.max(tmp, maxArea);
                    ++index;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0)
                    maxArea = Math.max(maxArea, changeArea(grid, map, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int m, int n, int index){
        if(m < 0 || m > grid.length-1 || n < 0 || n > grid[0].length-1 || grid[m][n] == 0)
            return 0;
        if(grid[m][n] > 1)
            return 0;
        int ans = 1;
        grid[m][n] = index;
        return ans + dfs(grid, m -1, n, index) +
                dfs(grid, m+1, n, index) +
                dfs(grid, m, n-1, index) +
                dfs(grid, m, n+1, index);
    }
    public int changeArea(int[][] grid, Map<Integer, Integer> map, int m, int n){
        Set<Integer> set = new HashSet<>();
        int newArea = 1;
        if(m - 1 >= 0) set.add(grid[m-1][n]);
        if(m + 1 < grid.length) set.add(grid[m+1][n]);
        if(n - 1 >= 0) set.add(grid[m][n-1]);
        if(n + 1 < grid[0].length) set.add(grid[m][n+1]);
        for(int s : set)
            newArea += map.get(s);
        return newArea;
    }
}

/*
class Solution {
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[] area = new int[250];
        int index = 2;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    area[index] = dfs(grid, i, j, index);
                    maxArea = Math.max(area[index], maxArea);
                    ++index;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0)
                    maxArea = Math.max(maxArea, changeArea(grid, area, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int m, int n, int index){
        if(m < 0 || m > grid.length-1 || n < 0 || n > grid[0].length-1 || grid[m][n] == 0)
            return 0;
        if(grid[m][n] > 1)
            return 0;
        int ans = 1;
        grid[m][n] = index;
        return ans + dfs(grid, m -1, n, index) +
                dfs(grid, m+1, n, index) +
                dfs(grid, m, n-1, index) +
                dfs(grid, m, n+1, index);
    }
    public int changeArea(int[][] grid, int[] area, int m, int n){
        Set<Integer> set = new HashSet<>();
        int newArea = 1;
        if(m - 1 >= 0) set.add(grid[m-1][n]);
        if(m + 1 < grid.length) set.add(grid[m+1][n]);
        if(n - 1 >= 0) set.add(grid[m][n-1]);
        if(n + 1 < grid[0].length) set.add(grid[m][n+1]);
        for(int s : set)
            newArea += area[s];
        return newArea;
    }
}
 */

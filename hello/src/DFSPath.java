import java.util.*;

/**
 * @author admin_cg
 * @data 2020/9/25 19:19
 */

class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
public class DFSPath {
    public static void main(String[] args) {
        int n = 10, m = 14;
        Interval[] temp = {new Interval(0,1), new Interval(0,2),new Interval(0,3),new Interval(1,4),new Interval(3,4)
                ,new Interval(2,6),new Interval(4,5),new Interval(5,6),new Interval(6,7),new Interval(7,8),
                new Interval(6,9),new Interval(9,10),new Interval(8,-1),new Interval(10,-1)};

        DFSPath dfsPath = new DFSPath();
        Interval interval = dfsPath.trim(n, m, temp);
        System.out.println(interval.toString());
    }
    List<Integer> ans = new ArrayList<>();
    public Deque<Integer> stack = new LinkedList<>();
    public Interval trim(int n, int m, Interval[] temp){
        int[][] graph = new int[n+2][n+2];
        for (int i = 0; i < m; i++) {
            if(temp[i].end == -1){
                graph[temp[i].start][n+1] = 1;
            }
            else{
                graph[temp[i].start][temp[i].end] = 1;
            }

        }
        boolean[] visit = new boolean[n+2];
        DFS(0, n+1, graph, visit);
        int a = 0;
        for (Integer an : ans) {
            a = (a + an) % 100000007;
        }
        return new Interval(ans.size()-1, a);
    }

    public void DFS(int start, int end, int[][] graph, boolean[] visit){
        visit[start] = true;
        stack.addLast(start);
        for(int j = 0; j < graph[start].length; j++){
            if(start == end){
                for (int i = 0; i < stack.size() - 1; i++) {
                    int t = stack.pollFirst();
                    if(!ans.contains(t)){
                        ans.add(t);
                    }
                    stack.addLast(t);
                }
                stack.pollLast();
                visit[start] = false;
                break;
            }
            if(!visit[j]){
                DFS(j, end, graph, visit);
            }
            if(j == graph[start].length - 1){
                stack.pop();
                visit[start] = false;
            }
        }
    }
}

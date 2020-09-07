package others.nowcode;
import java.util.*;


 class Point {
    int x;
    int y;
  }


public class cheak {
    /**
     * 能回到1号点返回 Yes，否则返回 No
     * @param param int整型一维数组 param[0] 为 n，param[1] 为 m
     * @param edge Point类一维数组 Point.x , Point.y 分别为一条边的两个点
     * @return string字符串
     */
    private int[] unionFindSet;
    private HashSet<Integer> nodeToOne;
    private HashSet<Integer> linkToOne;

    public String solve (int[] param, Point[] edge) {
        // write code here
        if(param[1] == 0) return "No";
        createUnionFindSet(param[0], edge);
        return isCircuit();
    }

    private String isCircuit(){
        for(Integer node : nodeToOne){
            Integer head = findHead(node);
            if(linkToOne.contains(head))
                return "Yes";
            else linkToOne.add(head);
        }
        return "No";
    }

    private void initialize(int n){
        unionFindSet = new int[n + 5];
        nodeToOne = new HashSet<Integer>(128);
        linkToOne = new HashSet<Integer>(128);
    }

    private void createUnionFindSet(int n, Point[] edge){
        initialize(n);
        for(Point p : edge){
            if(p.x == 1 || p.y == 1){
                int node = p.x != 1?p.x : p.y;
                nodeToOne.add(node);
            }else if(!isSameHead(p.x, p.y)){
                unionSet(p.x, p.y);
            }
        }
    }

    private boolean isSameHead(int x, int y){
        return findHead(x) == findHead(y);
    }
    private void unionSet(int u, int v){
        int uHead = findHead(u), vHead = findHead(v);
        unionFindSet[uHead] = vHead;
    }

    private int findHead(int node){
        int head = node;
        while(unionFindSet[head] != 0){
            head = unionFindSet[head];
        }
        int curNode = node, nextNode = unionFindSet[node];
        while(nextNode != 0){
            unionFindSet[curNode] = head;
            curNode = nextNode;
            nextNode = unionFindSet[nextNode];
        }
        return head;
    }
}
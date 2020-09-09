package tencent0906;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/9/6 20:34
 */
public class tencent0906 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        unionFind uf = new unionFind(n);
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int pre = 0;
            for (int j = 0; j < t; j++) {
                if(j == 0) {
                    pre = sc.nextInt();
                    continue;
                }
                uf.union(pre, sc.nextInt()); // 每个团体第一个合并
            }
        }
        System.out.println(uf.findZero(n));
    }

}

class unionFind{
    int[] parent;

    public unionFind(int num) {
        this.parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i; // 每个人初始化为自己
        }
    }
    public int find (int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]]; // 压缩查找
            x = parent[x];
        }
        return x;
    }
    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if(rootp == rootq) return; // 连通不用合并
        if(rootp < rootq)
            parent[rootq] = rootp; // 小的为根， 保证合并到0下
        else parent[rootp] = rootq;
    }
    public int findZero (int num){
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if(find(i) == 0)
                sum++;  // 寻找根为0的人
        }
        return sum;
    }
}

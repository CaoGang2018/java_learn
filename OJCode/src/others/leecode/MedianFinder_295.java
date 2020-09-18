package others.leecode;

import java.util.PriorityQueue;

/**
 * @author admin_cg
 * @date 2020/9/18 9:37
 */
public class MedianFinder_295 {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public MedianFinder_295() {
        large  = new PriorityQueue<>();
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if(small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        }
        else{
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if(large.size() < small.size())
            return small.peek();
        else if(large.size() > small.size())
            return large.peek();
        return (large.peek() + small.peek()) / 2.0;
    }
}

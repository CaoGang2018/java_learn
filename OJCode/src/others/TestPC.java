package others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin_cg
 * @date 2020/8/30 19:52
 */
public class TestPC {
    public static void main(String[] args) {
        Cache cache = new Cache(10);
        Producer p = new Producer(cache);
        Consumer c = new Consumer(cache);
        c.start();
        p.start();
    }


}

// 生产者
class Producer extends Thread {
    Cache cache;
    public Producer(Cache cache){
        this.cache = cache;
    }

    @Override
    public void run() {
        cache.produce("xx");
    }
}

// 消费者
class Consumer extends Thread {
    Cache cache;
    public Consumer(Cache cache){
        this.cache = cache;
    }
    @Override
    public void run() {
        cache.consume();
    }
}

class Cache {
    private Queue<String> MaxCacheSpace;
    private int maxCacheSize;
    int count;

    public Cache() {
    }

    public Cache(int maxCacheSize) {
        MaxCacheSpace = new LinkedList<>();
        this.maxCacheSize = maxCacheSize;
        this.count = 0;
    }

    public synchronized void produce(String m){
        if(MaxCacheSpace.size() >= maxCacheSize){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++count;
        MaxCacheSpace.offer(m);
        System.out.println(Thread.currentThread().getName() + " 生产了：" + m);
        this.notifyAll();

    }
    public synchronized void consume(){
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --count;
        System.out.println(Thread.currentThread().getName() + " 消费了：" + MaxCacheSpace.poll());
        this.notifyAll();
    }

}
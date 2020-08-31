package others;

/**
 * @author admin_cg
 * @date 2020/8/30 20:33
 */
public class print_to_100 {
    public static void main(String[] args) {
        Object lock = new Object();
        print_100 p1 = new print_100(1, lock, true);
        print_100 p2 = new print_100(2, lock, false);
        new Thread(p2, "even").start();
        new Thread(p1, "odd ").start();
    }

}
class print_100 implements Runnable {
    private int id;
    private final Object lock;
    boolean start;

    public print_100(int id, Object lock, boolean start) {
        this.id = id;
        this.lock = lock;
        this.start = start;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(id < 101){
                if(start){
                    start = false;
                }
                else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " get " + id);
                id += 2;
                lock.notify();
            }

        }
    }
}

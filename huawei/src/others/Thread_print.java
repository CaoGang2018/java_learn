package others;

/**
 * @author admin_cg
 * @date 2020/8/25 15:14
 */
public class Thread_print {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new print(false, lock, 2), "even").start();
        new Thread(new print(true, lock, 1), "odd").start();

    }

}


class print implements Runnable{
    private boolean runNow;
    private Object lock;
    private int num;

    public print(boolean runNow, Object lock, int num) {
        this.runNow = runNow;
        this.lock = lock;
        this.num = num;
    }

    @Override
    public void run(){
        synchronized(lock){
            while(num <= 100) {
                if (runNow) {
                    //第一次进来可以直接运行，但是循环第二次之后需要先等到唤醒才能运行
                    runNow = false;
                } else {
                    //先等待
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() +" -> " +num);
                num += 2;

                //通知其他线程运行
                lock.notify();
            }
        }
    }
}

package others.alternatePrint;

import java.util.concurrent.Semaphore;

/**
 * @author admin_cg
 * @date 2020/8/18 20:08
 */
public class PrintAlternate {
    public static void main(String[] args) {

        count ct = new count();
        person p = new person(ct);
        dog d = new dog(ct);
        new Thread(p).start();
        new Thread(d).start();


    }

}


// 自己写的
class person implements Runnable{
    count ct;

    public person(count ct) {
        this.ct = ct;
    }

    @Override
    public void run() {
        ct.out1();
    }
}
class dog implements Runnable{
    count ct;

    public dog(count ct) {
        this.ct = ct;
    }

    @Override
    public void run() {
        ct.out2();
    }
}

class count{
    int i = 1;
    boolean flag = true;

    public synchronized void out1(){

        while (true){
            if(!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(this.i > 100) return;
            System.out.println(Thread.currentThread().getName() + " get " + this.i++);
            this.notifyAll();
            this.flag = !this.flag;
        }
    }
    public synchronized void out2(){
        while (true){
            if(flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(this.i > 100) return;
            System.out.println(Thread.currentThread().getName() + " get " + this.i++);
            this.notifyAll();
            this.flag = !this.flag;
        }
    }
}
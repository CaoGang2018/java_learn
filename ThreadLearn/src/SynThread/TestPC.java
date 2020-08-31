package SynThread;

/**
 * 生产者， 消费者问题
 * @author admin_cg
 * @date 2020/8/11 10:15
 * 生产者， 消费者，产品， 容器
 */
public class TestPC {
    public static void main(String[] args) {
        synContainer container = new synContainer();
        Thread t1 = new Productor(container);
        Thread t2 = new Consumer(container);

        t1.start();
        t2.start();
    }

}

// 生产者
class Productor extends Thread{
    synContainer container = new synContainer();

    public Productor(synContainer container){
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产者生产了第 " + i + " 只鸡！");
        }
    }
}

// 消费者
class Consumer extends Thread {
    synContainer container = new synContainer();

    public Consumer(synContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费者消费了第 " + container.pop().getId() + " 只鸡!");
        }
    }
}

// 产品
class Chicken{
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

// 容器
class synContainer{
    Chicken[] chickens = new Chicken[10];
    int count; // 计数器

    public synchronized void push(Chicken chicken){
        // 判断容器是否满了
        if(count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        // 通知消费者
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        // 判断是否有商品
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];

        //通知生产
        this.notifyAll();
        return chicken;

    }
}



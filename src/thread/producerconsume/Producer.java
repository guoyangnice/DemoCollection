package thread.producerconsume;

import java.util.Queue;
import java.util.Random;

/**
 * 生产者线程
 * @author yangjie
 */
public class Producer implements Runnable{
    private Queue<Product> queue;
    private int maxCapacity;
    public Producer(){}

    public Producer(Queue queue,int maxCapacity){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void run() {
        synchronized (queue){
            while(queue.size() == maxCapacity){
                System.out.println("生产者消费已经满了！");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(queue.size() == 0){
                //如果没有产品，唤醒所有的生产者
                queue.notifyAll();
            }
            Random random = new Random();
            Integer i = random.nextInt();
            queue.offer(new Product("产品"  + i.toString()));
            System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品：" + i.toString());
            queue.notifyAll();
        }
    }
}

package thread.producerconsume;

import java.util.Queue;

/**
 *
 * @author yangjie
 */
public class Consumer implements Runnable{
    private Queue<Product> queue;
    private int maxCapacity;

    public Consumer(){}

    public Consumer(Queue queue,int maxCapacity){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void run() {
        synchronized (queue){
            while(queue.isEmpty()){
                System.out.println("消费者已经消费完！");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(queue.size() == maxCapacity){
                queue.notifyAll();
            }
            Product product = queue.poll();
            System.out.println("消费者" + Thread.currentThread().getName() + "消费了：" + product.getName());
        }
    }
}

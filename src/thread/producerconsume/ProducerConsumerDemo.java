package thread.producerconsume;

/**
 * 生产者和消费者问题-synchronized-wait-notify
 * 这种方式较为简单
 * @author yangjie
 */
public class ProducerConsumerDemo {
    private int number = 1;

    /**
     * 生产者
     * @throws InterruptedException
     */
    public synchronized void increment() throws InterruptedException {
        while(number != 0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>"+ number);
        this.notifyAll();
    }

    /**
     * 消费者
     * @throws InterruptedException
     */
    public synchronized void decrement() throws InterruptedException {
        while(number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notifyAll();
    }

    public static void main(String[] args) {
        ProducerConsumerDemo pc =  new ProducerConsumerDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10;i ++){
                    try {
                        pc.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10;i ++){
                    try {
                        pc.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
    }
}

package thread.printabcinorder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjie
 */
public class ReentrantLockDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for(int i = 0; i < 10; i++) {
                    while(count % 3 != 0){
                        //A线程释放了锁，但是阻塞了
                        A.await();
                    }
                    System.out.println("A");
                    count++;
                    //A线程执行完，唤醒B
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for(int i = 0; i < 10; i++) {
                    while(count % 3 != 1){
                        B.await();
                    }
                    System.out.println("B");
                    count++;
                    //A线程执行完，唤醒B
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for(int i = 0; i < 10; i++) {
                    while(count % 3 != 2){
                        C.await();
                    }
                    System.out.println("C");
                    count++;
                    //A线程执行完，唤醒B
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}

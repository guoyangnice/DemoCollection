package thread.producerconsume;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 与第一种一样的写法，synchronized-wait-notify
 * @author yangjie
 */
public class MainPc {
    public static void main(String[] args) {
        Queue<Product> queue = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            new Thread(new Producer(queue, 100)).start();
            new Thread(new Consumer(queue, 100)).start();
        }
    }
}

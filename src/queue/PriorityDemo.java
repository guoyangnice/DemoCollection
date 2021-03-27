package queue;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
            priorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = priorityQueue.poll();
            System.out.println("Processing Integer:"+in);
        }
    }
}
